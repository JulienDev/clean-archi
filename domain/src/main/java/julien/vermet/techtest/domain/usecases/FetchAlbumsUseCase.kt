package julien.vermet.techtest.domain.usecases

import julien.vermet.techtest.domain.models.Album
import julien.vermet.techtest.domain.repository.AlbumRepository
import kotlinx.coroutines.flow.Flow

class FetchAlbumsUseCase(
    private val albumRepository: AlbumRepository
) {

    fun fetch() : Flow<List<Album>> {
        return albumRepository.getAlbums()
    }

}