package julien.vermet.techtest.data

import io.reactivex.rxjava3.core.Single
import julien.vermet.techtest.common.BaseSchedulerProvider
import julien.vermet.techtest.data.mapper.Mapper
import julien.vermet.techtest.data.repository.AlbumCache
import julien.vermet.techtest.data.repository.AlbumRemote
import julien.vermet.techtest.domain.models.Album
import julien.vermet.techtest.domain.repository.AlbumRepository

class AlbumDataRepository(
    private val albumRemote: AlbumRemote,
    private val albumCache: AlbumCache,
    private val albumMapper: Mapper,
    private val schedulerProvider : BaseSchedulerProvider
) : AlbumRepository {

    override fun getAlbums(): Single<List<Album>> {
        return albumRemote.getAlbums()
            .subscribeOn(schedulerProvider.io())
            .flatMap { albums ->
                albumCache.deleteAlbums()
                    .andThen(albumCache.insertAlbums(albums))
                    .andThen(observeAlbumFromCache())
            }
            .onErrorResumeNext {
                observeAlbumFromCache()
            }
    }

    private fun observeAlbumFromCache(): Single<List<Album>> {
        return albumCache.getAlbums().map { albums ->
            albums.map { album -> albumMapper.fromEntity(album) }
        }
    }

}