package julien.vermet.techtest.remote.factory

import julien.vermet.techtest.data.model.AlbumEntity
import julien.vermet.techtest.remote.AlbumService
import julien.vermet.techtest.remote.model.AlbumModel

class AlbumFactory {

    companion object Factory {

        fun makeAlbumResponse(): List<AlbumModel> {
            return makeAlbumModelList(5)
        }
        
        fun makeAlbumModelList(count: Int): List<AlbumModel> {
            val albumEntities = mutableListOf<AlbumModel>()
            repeat(count) {
                albumEntities.add(makeAlbumModel())
            }
            return albumEntities
        }

        fun makeAlbumModel(): AlbumModel {
            return AlbumModel(0, 0, "title", "url", "thumbnailUrl")
        }

    }

}