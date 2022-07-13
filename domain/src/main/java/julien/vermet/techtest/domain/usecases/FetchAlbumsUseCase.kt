package julien.vermet.techtest.domain.usecases

import io.reactivex.rxjava3.core.Single
import julien.vermet.techtest.domain.models.Album
import julien.vermet.techtest.domain.repository.AlbumRepository

class FetchAlbumsUseCase(
    private val albumRepository: AlbumRepository
) {

    fun fetch() : Single<List<Album>> {
        return albumRepository.getAlbums()
    }

}