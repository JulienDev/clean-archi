package julien.vermet.techtest.remote.di

import android.content.Context
import julien.vermet.techtest.remote.BuildConfig
import julien.vermet.techtest.remote.R
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

val remoteModule = module {

    fun provideHttpLoggingInterceptor() {
        HttpLoggingInterceptor()
            .apply {
                level = if (BuildConfig.DEBUG) {
                    HttpLoggingInterceptor.Level.BODY
                } else {
                    HttpLoggingInterceptor.Level.NONE
                }
            }
    }

    fun provideOkhttpClient(loggingInterceptor: HttpLoggingInterceptor) {
        OkHttpClient.Builder()
            .apply { addInterceptor(loggingInterceptor) }
            .build()
    }

    fun provideRetrofit(
        context: Context,
        okHttpClient: OkHttpClient,
        moshiConverterFactory: MoshiConverterFactory,
        rxJava3CallAdapterFactory: RxJava3CallAdapterFactory
    ) {
        Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(context.getString(R.string.base_url))
            .addConverterFactory(moshiConverterFactory)
            .addCallAdapterFactory(rxJava3CallAdapterFactory)
            .build()
    }

    single {

    }

    single { provideHttpLoggingInterceptor() }
    single { provideOkhttpClient(loggingInterceptor = get()) }
    single {
        provideRetrofit(
            context = get(),
            okHttpClient = get(),
            moshiConverterFactory = get(),
            rxJava3CallAdapterFactory = get()
        )
    }
    single { MoshiConverterFactory.create() }
    single { RxJava3CallAdapterFactory.create() }

}