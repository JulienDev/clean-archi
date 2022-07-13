package julien.vermet.techtest.data.mapper

import julien.vermet.techtest.data.model.AlbumEntity
import julien.vermet.techtest.domain.models.Album

class AlbumMapper : Mapper {

    override fun mapToEntity(model: Album) : AlbumEntity {
        return AlbumEntity(model.albumId, model.id, model.title, model.url, model.thumbnailUrl)
    }

    override fun fromEntity(entity: AlbumEntity) : Album {
        return Album(entity.albumId, entity.id, entity.title, entity.url, entity.thumbnailUrl)
    }

}