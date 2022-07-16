package julien.vermet.techtest.cache.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import julien.vermet.techtest.cache.CachedAlbum

@Database(entities = [CachedAlbum::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun albumDao(): AlbumDao
}