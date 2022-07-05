package julien.vermet.techtest

import android.app.Application
import julien.vermet.techtest.presentation.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class TechTestApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin{
            androidLogger()
            androidContext(this@TechTestApplication)
            modules(presentationModule)
        }
    }

}