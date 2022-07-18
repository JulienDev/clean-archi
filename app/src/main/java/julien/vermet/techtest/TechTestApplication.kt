package julien.vermet.techtest

import android.app.Application
import julien.vermet.techtest.cache.di.cacheModule
import julien.vermet.techtest.common.di.commonModule
import julien.vermet.techtest.data.di.dataModule
import julien.vermet.techtest.domain.domainModule
import julien.vermet.techtest.presentation.di.presentationModule
import julien.vermet.techtest.remote.di.remoteModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class TechTestApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        setupKoin()
    }

    private fun setupKoin() {
        startKoin{
            androidLogger()
            androidContext(this@TechTestApplication)
            modules(commonModule, presentationModule, domainModule, remoteModule, dataModule, cacheModule)
        }
    }

}