package julien.vermet.techtest.domain.usecases

import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.verify
import io.reactivex.rxjava3.core.Single
import julien.vermet.techtest.domain.factory.AlbumFactory
import julien.vermet.techtest.domain.models.Album
import julien.vermet.techtest.domain.repository.AlbumRepository
import org.junit.Before
import org.junit.Test

class FetchAlbumsUseCaseTest {

    private lateinit var getAlbums: FetchAlbumsUseCase

    @MockK
    private lateinit var mockAlbumRepository: AlbumRepository

    @Before
    fun setUp() {
        MockKAnnotations.init(this, relaxed = true)

        getAlbums = FetchAlbumsUseCase(mockAlbumRepository)
    }

    @Test
    fun buildUseCaseObservableCallsRepository() {
        getAlbums.fetch()
        verify { mockAlbumRepository.getAlbums() }
    }

    @Test
    fun buildUseCaseObservableCompletes() {
        stubAlbumRepositoryGetAlbums(Single.just(AlbumFactory.makeAlbumList(2)))
        val testObserver = getAlbums.fetch().test()
        testObserver.assertComplete()
    }

    @Test
    fun buildUseCaseObservableReturnsData() {
        val albums = AlbumFactory.makeAlbumList(2)
        stubAlbumRepositoryGetAlbums(Single.just(albums))
        val testObserver = getAlbums.fetch().test()
        testObserver.assertValue(albums)
    }

    private fun stubAlbumRepositoryGetAlbums(single: Single<List<Album>>) {
        every { mockAlbumRepository.getAlbums() } returns single
    }

}