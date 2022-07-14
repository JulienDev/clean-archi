package julien.vermet.techtest.cache.di

import AlbumCacheImpl
import android.content.Context
import androidx.room.Room
import julien.vermet.techtest.cache.CachedAlbum
import julien.vermet.techtest.cache.db.AlbumDao
import julien.vermet.techtest.cache.db.AppDatabase
import julien.vermet.techtest.cache.mapper.AlbumEntityMapper
import julien.vermet.techtest.cache.mapper.EntityMapper
import julien.vermet.techtest.data.model.AlbumEntity
import julien.vermet.techtest.data.repository.AlbumCache
import org.koin.dsl.module

val cacheModule = module {

    fun provideDatabase(context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "app-database")
            .fallbackToDestructiveMigration()
            .build()
    }

    fun provideAlbumDao(appDatabase: AppDatabase) : AlbumDao {
        return appDatabase.albumDao()
    }

    fun provideAlbumCacheRemote(mapper: EntityMapper<CachedAlbum, AlbumEntity>, albumDao: AlbumDao): AlbumCache {
        return AlbumCacheImpl(mapper = mapper, albumDao = albumDao)
    }

    single { provideDatabase(context = get()) }
    single { provideAlbumDao(appDatabase = get()) }
    single { provideAlbumCacheRemote(mapper = get(), albumDao = get()) }
    single<EntityMapper<CachedAlbum, AlbumEntity>> { AlbumEntityMapper() }

}