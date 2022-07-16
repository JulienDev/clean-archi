package julien.vermet.techtest.remote.mapper

import julien.vermet.techtest.remote.factory.AlbumFactory
import junit.framework.Assert.assertEquals
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
    fun mapFromRemoteMapsData() {
        val albumModel = AlbumFactory.makeAlbumModel()
        val albumEntity = albumEntityMapper.mapFromRemote(albumModel)

        assertEquals(albumModel.albumId, albumEntity.albumId)
        assertEquals(albumModel.id, albumEntity.id)
        assertEquals(albumModel.title, albumEntity.title)
        assertEquals(albumModel.url, albumEntity.url)
        assertEquals(albumModel.thumbnailUrl, albumEntity.thumbnailUrl)
    }

}