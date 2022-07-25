package julien.vermet.techtest.cache.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import julien.vermet.techtest.cache.CachedAlbum

@Dao
interface AlbumDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(albums: List<CachedAlbum>)

    @Query("SELECT * FROM albums")
    suspend fun getAll(): List<CachedAlbum>

    @Query("DELETE FROM albums")
    suspend fun deleteAlbums()

}