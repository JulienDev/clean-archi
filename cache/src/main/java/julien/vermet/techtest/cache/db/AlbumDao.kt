package julien.vermet.techtest.cache.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import julien.vermet.techtest.cache.CachedAlbum

@Dao
interface AlbumDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(albums: List<CachedAlbum>) : Completable

    @Query("SELECT * FROM albums")
    fun getAll(): Single<List<CachedAlbum>>

    @Query("DELETE FROM albums")
    fun deleteAlbums() : Completable

}