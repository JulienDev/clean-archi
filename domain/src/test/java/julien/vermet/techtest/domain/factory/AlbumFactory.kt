package julien.vermet.techtest.domain.factory

import julien.vermet.techtest.domain.models.Album

class AlbumFactory {

    companion object Factory {

        fun makeAlbumList(count: Int): List<Album> {
            val albums = mutableListOf<Album>()
            repeat(count) {
                albums.add(makeAlbum())
            }
            return albums
        }

        fun makeAlbum(): Album {
            return Album(0, 0, "title", "url", "thumbnailUrl")
        }

    }

}