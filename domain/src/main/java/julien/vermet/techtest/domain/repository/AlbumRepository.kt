package julien.vermet.techtest.domain.repository

import julien.vermet.techtest.domain.models.Album
import kotlinx.coroutines.flow.Flow

interface AlbumRepository {

    fun getAlbums(): Flow<List<Album>>

}