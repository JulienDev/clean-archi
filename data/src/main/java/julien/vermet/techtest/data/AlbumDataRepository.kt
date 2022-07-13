package julien.vermet.techtest.data

import io.reactivex.rxjava3.core.Single
import julien.vermet.techtest.data.mapper.AlbumMapper
import julien.vermet.techtest.data.mapper.Mapper
import julien.vermet.techtest.data.repository.AlbumRemote
import julien.vermet.techtest.domain.models.Album
import julien.vermet.techtest.domain.repository.AlbumRepository

class AlbumDataRepository(
    private val albumRemote: AlbumRemote,
    private val albumMapper: Mapper
) : AlbumRepository {

    override fun getAlbums(): Single<List<Album>> {
        return albumRemote.getAlbums()
            .map { albums ->
                albums.map { album -> albumMapper.fromEntity(album) }
            }
    }

}