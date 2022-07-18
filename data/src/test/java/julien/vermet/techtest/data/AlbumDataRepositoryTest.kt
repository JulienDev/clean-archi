package julien.vermet.techtest.data

import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.verify
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import julien.vermet.techtest.common.TestSchedulerProvider
import julien.vermet.techtest.data.mapper.Mapper
import julien.vermet.techtest.data.repository.AlbumCache
import julien.vermet.techtest.data.repository.AlbumRemote
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class AlbumDataRepositoryTest {

    private lateinit var repository: AlbumDataRepository

    @MockK
    private lateinit var albumRemote: AlbumRemote
    @MockK
    private lateinit var albumCache: AlbumCache
    @MockK
    private lateinit var albumMapper: Mapper

    private val schedulerProvider = TestSchedulerProvider()

    @Before
    fun setUp() {
        MockKAnnotations.init(this, relaxed = true)
        repository = AlbumDataRepository(albumRemote, albumCache, albumMapper, schedulerProvider)


        every { albumCache.deleteAlbums() } returns Completable.complete()
        every { albumCache.insertAlbums(any()) } returns Completable.complete()
//        every { mapper.mapToUI(testAlbum) } returns testAlbumUI
    }

    @Test
    fun `when remote request success, store in database, then load from db`() {
        every { albumRemote.getAlbums() } returns Single.just(emptyList())

        repository.getAlbums().test()
        schedulerProvider.io().triggerActions()

        verify {
            albumCache.deleteAlbums()
            albumCache.insertAlbums(emptyList())
            albumCache.getAlbums()
        }
    }

    @Test
    fun `when remote request fail, load from db`() {
        every { albumRemote.getAlbums() } returns Single.error(Exception())

        repository.getAlbums().test()
        schedulerProvider.io().triggerActions()

        verify(exactly = 0) {
            albumCache.deleteAlbums()
            albumCache.insertAlbums(emptyList())
        }
        verify {
            albumCache.getAlbums()
        }
    }

}