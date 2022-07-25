package julien.vermet.techtest.data.repository

import julien.vermet.techtest.data.model.AlbumEntity

interface AlbumCache {

    suspend fun insertAlbums(albums: List<AlbumEntity>)

    suspend fun getAlbums(): List<AlbumEntity>

    suspend fun deleteAlbums()
}