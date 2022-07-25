package julien.vermet.techtest.remote

import julien.vermet.techtest.data.model.AlbumEntity
import julien.vermet.techtest.data.repository.AlbumRemote
import julien.vermet.techtest.remote.mapper.EntityMapper
import julien.vermet.techtest.remote.model.AlbumModel

class AlbumRemoteImpl(
    private val albumService: AlbumService,
    private val albumEntityMapper: EntityMapper<AlbumModel, AlbumEntity>
) : AlbumRemote {

    override suspend fun getAlbums(): List<AlbumEntity> {
        return albumService.getAlbums()
            .map { albumModel -> albumEntityMapper.mapFromRemote(albumModel) }
    }

}