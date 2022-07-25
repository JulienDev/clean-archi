package julien.vermet.techtest.data

import io.mockk.*
import io.mockk.impl.annotations.MockK
import julien.vermet.techtest.data.mapper.Mapper
import julien.vermet.techtest.data.repository.AlbumCache
import julien.vermet.techtest.data.repository.AlbumRemote
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@OptIn(ExperimentalCoroutinesApi::class)
@RunWith(JUnit4::class)
class AlbumDataRepositoryTest {

    private lateinit var repository: AlbumDataRepository

    @MockK
    private lateinit var albumRemote: AlbumRemote

    @MockK
    private lateinit var albumCache: AlbumCache

    @MockK
    private lateinit var albumMapper: Mapper

    private val dispatcher = StandardTestDispatcher()

    @Before
    fun setUp() {
        Dispatchers.setMain(dispatcher)
        MockKAnnotations.init(this, relaxed = true)
        repository = AlbumDataRepository(albumRemote, albumCache, albumMapper)
    }


    @Test
    fun `when remote request success, store in database, then load from db`() = runTest {
        coEvery { albumRemote.getAlbums() } returns emptyList()

        repository.getAlbums().last()

        coVerify {
            albumCache.deleteAlbums()
            albumCache.insertAlbums(emptyList())
            albumCache.getAlbums()
        }
    }

    @Test
    fun `when remote request fail, load from db`() = runTest {
        coEvery { albumRemote.getAlbums() } throws Exception()

        repository.getAlbums().last()

        coVerify(exactly = 0) {
            albumCache.deleteAlbums()
            albumCache.insertAlbums(emptyList())
        }
        coVerify {
            albumCache.getAlbums()
        }
    }

}