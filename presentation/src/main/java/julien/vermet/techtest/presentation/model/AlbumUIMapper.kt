package julien.vermet.techtest.presentation.model

import julien.vermet.techtest.domain.models.Album

class AlbumUIMapper {

    fun map(albums : List<Album>) : List<AlbumUI> {
        return albums.map { album -> album.map() }
    }

    private fun Album.map() : AlbumUI {
        return AlbumUI(
            title = title,
            imageUrl = imageUrl,
        )
    }

}