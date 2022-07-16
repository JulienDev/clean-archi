package julien.vermet.techtest.presentation.mapper

import julien.vermet.techtest.presentation.factory.AlbumFactory
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
    fun mapToViewMapsData() {
        val album = AlbumFactory.makeAlbum()
        val albumUI = albumMapper.mapToUI(album)

        assertEquals(albumUI.albumId, album.albumId)
        assertEquals(albumUI.id, album.id)
        assertEquals(albumUI.title, album.title)
        assertEquals(albumUI.url, album.url)
        assertEquals(albumUI.thumbnailUrl, album.thumbnailUrl)
    }

}