package julien.vermet.techtest.domain.usecases

import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.verify
import julien.vermet.techtest.domain.factory.AlbumFactory
import julien.vermet.techtest.domain.models.Album
import julien.vermet.techtest.domain.repository.AlbumRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class FetchAlbumsUseCaseTest {

    private lateinit var getAlbums: FetchAlbumsUseCase

    @MockK
    private lateinit var mockAlbumRepository: AlbumRepository
    private val dispatcher = StandardTestDispatcher()

    @Before
    fun setUp() {
        Dispatchers.setMain(dispatcher)
        MockKAnnotations.init(this, relaxed = true)

        getAlbums = FetchAlbumsUseCase(mockAlbumRepository)
    }

    @Test
    fun buildUseCaseObservableReturnsData() = runTest {
        val albums = AlbumFactory.makeAlbumList(2)
        coEvery { mockAlbumRepository.getAlbums() } returns flow { emit(albums) }

        val fetched = getAlbums.fetch().last()
        assert(fetched == albums)
    }

}