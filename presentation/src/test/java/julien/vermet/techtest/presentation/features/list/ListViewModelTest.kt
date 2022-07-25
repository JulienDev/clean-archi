package julien.vermet.techtest.presentation.features.list

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleRegistry
import io.mockk.*
import io.mockk.impl.annotations.MockK
import julien.vermet.techtest.domain.models.Album
import julien.vermet.techtest.domain.usecases.FetchAlbumsUseCase
import julien.vermet.techtest.presentation.factory.AlbumFactory
import julien.vermet.techtest.presentation.mapper.Mapper
import julien.vermet.techtest.presentation.model.AlbumUI
import julien.vermet.techtest.testing.captureValues
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.*
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@OptIn(ExperimentalCoroutinesApi::class)
@RunWith(JUnit4::class)
class ListViewModelTest {

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    private lateinit var listViewModel: ListViewModel

    @MockK
    private lateinit var fetchAlbumsUseCase: FetchAlbumsUseCase

    @MockK
    private lateinit var mapper: Mapper<AlbumUI, Album>
    private val dispatcher = StandardTestDispatcher()

    private val testAlbum = AlbumFactory.makeAlbum()
    private val testAlbumUI = AlbumFactory.makeAlbumUI()
    private val testAlbums = listOf(testAlbum, testAlbum, testAlbum)
    private val testAlbumsUI = listOf(testAlbumUI, testAlbumUI, testAlbumUI)


    @Before
    fun setUp() {
        Dispatchers.setMain(dispatcher)
        MockKAnnotations.init(this, relaxed = true)
        listViewModel = ListViewModel(fetchAlbumsUseCase, mapper)

        coEvery { fetchAlbumsUseCase.fetch() } returns flow { emit(testAlbums) }
        coEvery { mapper.mapToUI(testAlbum) } returns testAlbumUI
    }


    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `when onCreate is called, fetch use case is called`() {
        runTest {  }
        coVerify(exactly = 1) { fetchAlbumsUseCase.fetch() }
    }

    @Test
    fun `when retry is clicked, fetch use case is called again`() {
        runTest {  listViewModel.onRetryClick() }
        coVerify(exactly = 2) { fetchAlbumsUseCase.fetch() }
    }

    @Test
    fun `when fetch sucesss, state is loading then ready`() {
        val listStateValues = listViewModel.listStateLiveData.captureValues()
        runTest {  }

        assert(listStateValues[0] == ListStateLoading)
        assert(listStateValues[1] == ListStateReady(testAlbumsUI))
    }

    @Test
    fun `when fetch fail, state is loading then error`() {
        coEvery { fetchAlbumsUseCase.fetch() } returns flow { throw Exception() }

        val listStateValues = listViewModel.listStateLiveData.captureValues()
        runTest {  }

        assert(listStateValues[0] == ListStateLoading)
        assert(listStateValues[1] == ListStateError)
    }
}