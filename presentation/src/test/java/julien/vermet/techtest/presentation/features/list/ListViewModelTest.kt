package julien.vermet.techtest.presentation.features.list

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleRegistry
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import io.mockk.verify
import io.reactivex.rxjava3.core.Single
import julien.vermet.techtest.common.TestSchedulerProvider
import julien.vermet.techtest.domain.models.Album
import julien.vermet.techtest.domain.usecases.FetchAlbumsUseCase
import julien.vermet.techtest.presentation.factory.AlbumFactory
import julien.vermet.techtest.presentation.mapper.Mapper
import julien.vermet.techtest.presentation.model.AlbumUI
import julien.vermet.techtest.testing.captureValues
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class ListViewModelTest {

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    private lateinit var listViewModel: ListViewModel

    @MockK
    private lateinit var fetchAlbumsUseCase: FetchAlbumsUseCase

    @MockK
    private lateinit var mapper: Mapper<AlbumUI, Album>
    private val schedulerProvider = TestSchedulerProvider()

    private val lifecycleRegistry = LifecycleRegistry.createUnsafe(mockk())


    private val testAlbum = AlbumFactory.makeAlbum()
    private val testAlbumUI = AlbumFactory.makeAlbumUI()
    private val testAlbums = listOf(testAlbum, testAlbum, testAlbum)
    private val testAlbumsUI = listOf(testAlbumUI, testAlbumUI, testAlbumUI)

    @Before
    fun setUp() {
        MockKAnnotations.init(this, relaxed = true)
        listViewModel = ListViewModel(fetchAlbumsUseCase, mapper, schedulerProvider)
        lifecycleRegistry.addObserver(listViewModel)

        every { fetchAlbumsUseCase.fetch() } returns Single.just(testAlbums)
        every { mapper.mapToUI(testAlbum) } returns testAlbumUI
    }

    @Test
    fun `when onCreate is called, fetch use case is called`() {
        lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_CREATE)
        verify(exactly = 1) { fetchAlbumsUseCase.fetch() }
    }

    @Test
    fun `when retry is clicked, fetch use case is called again`() {
        lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_CREATE)
        listViewModel.onRetryClick()
        verify(exactly = 2) { fetchAlbumsUseCase.fetch() }
    }

    @Test
    fun `when fetch sucesss, state is loading then ready`() {
        val listStateValues = listViewModel.listStateLiveData.captureValues()

        lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_CREATE)

        schedulerProvider.ui().triggerActions()

        assert(listStateValues[0] == ListStateLoading)
        assert(listStateValues[1] == ListStateReady(testAlbumsUI))
    }

    @Test
    fun `when fetch fail, state is loading then error`() {
        every { fetchAlbumsUseCase.fetch() } returns Single.error(Exception())

        val listStateValues = listViewModel.listStateLiveData.captureValues()

        lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_CREATE)

        schedulerProvider.ui().triggerActions()

        assert(listStateValues[0] == ListStateLoading)
        assert(listStateValues[1] == ListStateError)
    }
}