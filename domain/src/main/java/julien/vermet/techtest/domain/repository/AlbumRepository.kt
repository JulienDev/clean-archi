package julien.vermet.techtest.domain.repository

import io.reactivex.rxjava3.core.Single
import julien.vermet.techtest.domain.models.Album

interface AlbumRepository {

    fun getAlbums(): Single<List<Album>>

}