package julien.vermet.techtest.remote

import io.reactivex.rxjava3.core.Single
import julien.vermet.techtest.data.repository.AlbumRemote
import julien.vermet.techtest.remote.mapper.AlbumEntityMapper
import julien.vermet.techtest.data.model.AlbumEntity
import julien.vermet.techtest.remote.mapper.EntityMapper
import julien.vermet.techtest.remote.model.AlbumModel

class AlbumRemoteImpl(
    private val albumService: AlbumService,
    private val albumEntityMapper: EntityMapper<AlbumModel, AlbumEntity>
) : AlbumRemote {

    override fun getAlbums(): Single<List<AlbumEntity>> {
        return albumService.getAlbums()
            .map { albums ->
                albums.map { album -> albumEntityMapper.mapFromRemote(album) }
            }
    }

}