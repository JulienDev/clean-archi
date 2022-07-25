package julien.vermet.techtest.remote

import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import julien.vermet.techtest.remote.factory.AlbumFactory
import julien.vermet.techtest.remote.mapper.AlbumEntityMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@OptIn(ExperimentalCoroutinesApi::class)
@RunWith(JUnit4::class)
class AlbumRemoteImplTest {

    @MockK
    private lateinit var entityMapper: AlbumEntityMapper
    @MockK
    private lateinit var albumService: AlbumService

    private lateinit var albumRemoteImpl: AlbumRemoteImpl
    private val dispatcher = StandardTestDispatcher()

    @Before
    fun setup() {
        Dispatchers.setMain(dispatcher)
        MockKAnnotations.init(this, relaxed = true)
        albumRemoteImpl = AlbumRemoteImpl(albumService, entityMapper)
    }

    @Test
    fun getAlbumsReturnsData() = runTest {
        val albumResponse = AlbumFactory.makeAlbumResponse()
        coEvery { albumService.getAlbums() } returns albumResponse

        val albumEntities = albumRemoteImpl.getAlbums()
        val albumModels = albumResponse.map { model ->
            entityMapper.mapFromRemote(model)
        }

        assert(albumEntities == albumModels)
    }

}