package julien.vermet.techtest.data.repository

import io.reactivex.rxjava3.core.Single
import julien.vermet.techtest.data.model.AlbumEntity

interface AlbumRemote {

    fun getAlbums(): Single<List<AlbumEntity>>

}