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

        fun makeAlbumEntityList(count: Int): List<AlbumEntity> {
            val albumEntities = mutableListOf<AlbumEntity>()
            repeat(count) {
                albumEntities.add(makeAlbumEntity())
            }
            return albumEntities
        }

        fun makeAlbumList(count: Int): List<Album> {
            val albums = mutableListOf<Album>()
            repeat(count) {
                albums.add(makeAlbum())
            }
            return albums
        }

    }

}