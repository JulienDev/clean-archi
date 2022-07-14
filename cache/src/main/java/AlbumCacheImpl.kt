import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import julien.vermet.techtest.cache.CachedAlbum
import julien.vermet.techtest.cache.db.AlbumDao
import julien.vermet.techtest.cache.mapper.EntityMapper
import julien.vermet.techtest.data.model.AlbumEntity
import julien.vermet.techtest.data.repository.AlbumCache

class AlbumCacheImpl(
    private val mapper: EntityMapper<CachedAlbum, AlbumEntity>,
    private val albumDao: AlbumDao
) : AlbumCache {

    override fun insertAlbums(albums: List<AlbumEntity>): Completable {
        val cachedAlbums = albums.map { mapper.mapToCached(it) }
        return albumDao.insertAll(cachedAlbums)
    }

    override fun getAlbums(): Single<List<AlbumEntity>> {
        return albumDao.getAll().map { albums -> albums.map { mapper.mapFromCached(it) } }
    }

    override fun deleteAlbums(): Completable {
        return albumDao.deleteAlbums()
    }

}