package julien.vermet.techtest.remote

import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.reactivex.rxjava3.core.Single
import julien.vermet.techtest.remote.factory.AlbumFactory
import julien.vermet.techtest.remote.mapper.AlbumEntityMapper
import julien.vermet.techtest.remote.model.AlbumModel
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class AlbumRemoteImplTest {

    @MockK
    private lateinit var entityMapper: AlbumEntityMapper
    @MockK
    private lateinit var albumService: AlbumService

    private lateinit var albumRemoteImpl: AlbumRemoteImpl

    @Before
    fun setup() {
        MockKAnnotations.init(this, relaxed = true)
        albumRemoteImpl = AlbumRemoteImpl(albumService, entityMapper)
    }

    @Test
    fun getAlbumsCompletes() {
        stubAlbumServiceGetAlbums(Single.just(AlbumFactory.makeAlbumResponse()))
        val testObserver = albumRemoteImpl.getAlbums().test()
        testObserver.assertComplete()
    }

    @Test
    fun getAlbumsReturnsData() {
        val albumResponse = AlbumFactory.makeAlbumResponse()
        stubAlbumServiceGetAlbums(Single.just(albumResponse))
        val albumEntities = albumResponse.map { entityMapper.mapFromRemote(it) }

        val testObserver = albumRemoteImpl.getAlbums().test()
        testObserver.assertValue(albumEntities)
    }

    private fun stubAlbumServiceGetAlbums(single: Single<List<AlbumModel>>) {
        every { albumService.getAlbums() } returns single
    }
    
}