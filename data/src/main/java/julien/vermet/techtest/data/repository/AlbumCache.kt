package julien.vermet.techtest.data.repository

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import julien.vermet.techtest.data.model.AlbumEntity

interface AlbumCache {

    fun insertAlbums(albums: List<AlbumEntity>): Completable

    fun getAlbums(): Single<List<AlbumEntity>>

    fun deleteAlbums(): Completable
}