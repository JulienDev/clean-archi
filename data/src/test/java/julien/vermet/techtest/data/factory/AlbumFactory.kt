package julien.vermet.techtest.data.factory

import julien.vermet.techtest.data.model.AlbumEntity
import julien.vermet.techtest.domain.models.Album

class AlbumFactory {

    companion object Factory {

        fun makeAlbumEntity(): AlbumEntity {
            return AlbumEntity(0, 0, "title", "url", "thumbnailUrl")
        }

        fun makeAlbum(): Album {
            return Album(0, 0, "title", "url", "thumbnailUrl")
        }

    }

}