package julien.vermet.techtest.data.mapper

import julien.vermet.techtest.data.factory.AlbumFactory
import julien.vermet.techtest.data.model.AlbumEntity
import julien.vermet.techtest.domain.models.Album
import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class AlbumMapperTest {

    private lateinit var albumMapper: AlbumMapper

    @Before
    fun setUp() {
        albumMapper = AlbumMapper()
    }

    @Test
    fun mapFromEntityMapsData() {
        val albumEntity = AlbumFactory.makeAlbumEntity()
        val album = albumMapper.fromEntity(albumEntity)

        assertAlbumDataEquality(albumEntity, album)
    }

    @Test
    fun mapToEntityMapsData() {
        val cachedAlbum = AlbumFactory.makeAlbum()
        val albumEntity = albumMapper.mapToEntity(cachedAlbum)

        assertAlbumDataEquality(albumEntity, cachedAlbum)
    }

    private fun assertAlbumDataEquality(albumEntity: AlbumEntity,
                                           album: Album) {
        assertEquals(albumEntity.albumId, album.albumId)
        assertEquals(albumEntity.id, album.id)
        assertEquals(albumEntity.title, album.title)
        assertEquals(albumEntity.url, album.url)
        assertEquals(albumEntity.thumbnailUrl, album.thumbnailUrl)
    }

}