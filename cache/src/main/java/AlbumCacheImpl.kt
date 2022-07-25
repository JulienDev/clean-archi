import julien.vermet.techtest.cache.CachedAlbum
import julien.vermet.techtest.cache.db.AlbumDao
import julien.vermet.techtest.cache.mapper.EntityMapper
import julien.vermet.techtest.data.model.AlbumEntity
import julien.vermet.techtest.data.repository.AlbumCache

class AlbumCacheImpl(
    private val mapper: EntityMapper<CachedAlbum, AlbumEntity>,
    private val albumDao: AlbumDao
) : AlbumCache {

    override suspend fun insertAlbums(albums: List<AlbumEntity>) {
        val cachedAlbums = albums.map { mapper.mapToCached(it) }
        return albumDao.insertAll(cachedAlbums)
    }

    override suspend fun getAlbums(): List<AlbumEntity> {
        return albumDao.getAll().map { album -> mapper.mapFromCached(album) }
    }

    override suspend fun deleteAlbums() {
        return albumDao.deleteAlbums()
    }

}