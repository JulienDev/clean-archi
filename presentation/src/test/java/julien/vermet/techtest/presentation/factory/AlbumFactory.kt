package julien.vermet.techtest.presentation.factory

import julien.vermet.techtest.domain.models.Album
import julien.vermet.techtest.presentation.model.AlbumUI

class AlbumFactory {

    companion object Factory {

        fun makeAlbum(): Album {
            return Album(0, 0, "title", "url", "thumbnailUrl")
        }

        fun makeAlbumUI(): AlbumUI {
            return AlbumUI(0, 0, "title", "url", "thumbnailUrl")
        }

    }

}