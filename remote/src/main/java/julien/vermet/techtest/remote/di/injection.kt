package julien.vermet.techtest.remote.di

import android.content.Context
import julien.vermet.techtest.data.model.AlbumEntity
import julien.vermet.techtest.data.repository.AlbumRemote
import julien.vermet.techtest.remote.AlbumRemoteImpl
import julien.vermet.techtest.remote.AlbumService
import julien.vermet.techtest.remote.BuildConfig
import julien.vermet.techtest.remote.R
import julien.vermet.techtest.remote.mapper.AlbumEntityMapper
import julien.vermet.techtest.remote.mapper.EntityMapper
import julien.vermet.techtest.remote.model.AlbumModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val remoteModule = module {

    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor()
            .apply {
                level = if (BuildConfig.DEBUG) {
                    HttpLoggingInterceptor.Level.BODY
                } else {
                    HttpLoggingInterceptor.Level.NONE
                }
            }
    }

    fun provideOkhttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .apply { addInterceptor(loggingInterceptor) }
            .build()
    }

    fun provideRetrofit(
        context: Context,
        okHttpClient: OkHttpClient,
        moshiConverterFactory: MoshiConverterFactory
    ): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(context.getString(R.string.base_url))
            .addConverterFactory(moshiConverterFactory)
            .build()
    }

    fun provideAlbumService(retrofit: Retrofit): AlbumService {
        return retrofit.create(AlbumService::class.java)
    }

    fun provideAlbumRemote(albumService: AlbumService, albumEntityMapper: EntityMapper<AlbumModel, AlbumEntity>): AlbumRemote {
        return AlbumRemoteImpl(albumService = albumService, albumEntityMapper = albumEntityMapper)
    }

    single { provideHttpLoggingInterceptor() }
    single { provideOkhttpClient(loggingInterceptor = get()) }
    single {
        provideRetrofit(
            context = get(),
            okHttpClient = get(),
            moshiConverterFactory = get()
        )
    }
    single { MoshiConverterFactory.create() }
    single { provideAlbumService(retrofit = get()) }
    single { provideAlbumRemote(albumService = get(), albumEntityMapper = get()) }
    single<EntityMapper<AlbumModel, AlbumEntity>> { AlbumEntityMapper() }

}