package julien.vermet.techtest.data.mapper

import julien.vermet.techtest.data.model.AlbumEntity
import julien.vermet.techtest.domain.models.Album

interface Mapper {

    fun mapToEntity(model: Album) : AlbumEntity
    fun fromEntity(entity: AlbumEntity) : Album

}