package julien.vermet.techtest.data

import julien.vermet.techtest.data.mapper.Mapper
import julien.vermet.techtest.data.repository.AlbumCache
import julien.vermet.techtest.data.repository.AlbumRemote
import julien.vermet.techtest.domain.models.Album
import julien.vermet.techtest.domain.repository.AlbumRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onEach

class AlbumDataRepository(
    private val albumRemote: AlbumRemote,
    private val albumCache: AlbumCache,
    private val albumMapper: Mapper
) : AlbumRepository {

    override fun getAlbums(): Flow<List<Album>> {
        return flow {
            val remoteAlbums = albumRemote.getAlbums()
            albumCache.deleteAlbums()
            albumCache.insertAlbums(remoteAlbums)
            val albums = getAlbumsFromCache()
            emit(albums)
        }.catch {
            val albums = getAlbumsFromCache()
            emit(albums)
        }
    }

    private suspend fun getAlbumsFromCache(): List<Album> {
        val cachedAlbums = albumCache.getAlbums()
         return cachedAlbums.map { album -> albumMapper.fromEntity(album) }
    }

}