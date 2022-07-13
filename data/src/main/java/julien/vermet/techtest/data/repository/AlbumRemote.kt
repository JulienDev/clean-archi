package julien.vermet.techtest.data.repository

import io.reactivex.rxjava3.core.Single
import julien.vermet.techtest.data.model.AlbumEntity
import julien.vermet.techtest.domain.models.Album

interface AlbumRemote {

    fun getAlbums(): Single<List<AlbumEntity>>

}