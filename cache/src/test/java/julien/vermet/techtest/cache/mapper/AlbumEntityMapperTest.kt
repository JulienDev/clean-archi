package julien.vermet.techtest.cache.mapper

import julien.vermet.techtest.cache.CachedAlbum
import julien.vermet.techtest.cache.factory.AlbumFactory
import julien.vermet.techtest.data.model.AlbumEntity
import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4


@RunWith(JUnit4::class)
class AlbumEntityMapperTest {

    private lateinit var albumEntityMapper: AlbumEntityMapper

    @Before
    fun setUp() {
        albumEntityMapper = AlbumEntityMapper()
    }

    @Test
    fun mapToCachedMapsData() {
        val albumEntity = AlbumFactory.makeAlbumEntity()
        val cachedAlbum = albumEntityMapper.mapToCached(albumEntity)

        assertAlbumDataEquality(albumEntity, cachedAlbum)
    }

    @Test
    fun mapFromCachedMapsData() {
        val cachedAlbum = AlbumFactory.makeCachedAlbum()
        val albumEntity = albumEntityMapper.mapFromCached(cachedAlbum)

        assertAlbumDataEquality(albumEntity, cachedAlbum)
    }

    private fun assertAlbumDataEquality(albumEntity: AlbumEntity,
                                        cachedAlbum: CachedAlbum
    ) {
        assertEquals(albumEntity.albumId, cachedAlbum.albumId)
        assertEquals(albumEntity.id, cachedAlbum.id)
        assertEquals(albumEntity.title, cachedAlbum.title)
        assertEquals(albumEntity.url, cachedAlbum.url)
        assertEquals(albumEntity.thumbnailUrl, cachedAlbum.thumbnailUrl)
    }

}