package julien.vermet.techtest.data.repository

import julien.vermet.techtest.data.model.AlbumEntity

interface AlbumRemote {

    suspend fun getAlbums(): List<AlbumEntity>

}