package julien.vermet.techtest.cache.factory

import julien.vermet.techtest.cache.CachedAlbum
import julien.vermet.techtest.data.model.AlbumEntity

class AlbumFactory {
    
    companion object Factory {

        fun makeCachedAlbum(): CachedAlbum {
            return CachedAlbum(0, 0, "title", "url", "thumbnailUrl")
        }

        fun makeAlbumEntity(): AlbumEntity {
            return AlbumEntity(0, 0, "title", "url", "thumbnailUrl")
        }

    }

}