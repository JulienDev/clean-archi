package julien.vermet.techtest.remote.mapper

import julien.vermet.techtest.data.model.AlbumEntity
import julien.vermet.techtest.remote.model.AlbumModel

class AlbumEntityMapper : EntityMapper<AlbumModel, AlbumEntity> {

    override fun mapFromRemote(model: AlbumModel) : AlbumEntity {
        return AlbumEntity(model.albumId, model.id, model.title, model.url, model.thumbnailUrl)
    }

}