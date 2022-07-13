package julien.vermet.techtest.presentation.mapper

import julien.vermet.techtest.domain.models.Album
import julien.vermet.techtest.presentation.model.AlbumUI

class AlbumMapper : Mapper<AlbumUI, Album> {

    override fun mapToUI(type: Album): AlbumUI {
        return AlbumUI(type.albumId, type.id, type.title, type.url, type.thumbnailUrl)
    }

}