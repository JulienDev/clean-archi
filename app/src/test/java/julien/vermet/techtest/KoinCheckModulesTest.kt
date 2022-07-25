package julien.vermet.techtest

import android.app.Application
import android.content.Context
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import julien.vermet.techtest.cache.di.cacheModule
import julien.vermet.techtest.data.di.dataModule
import julien.vermet.techtest.domain.domainModule
import julien.vermet.techtest.presentation.di.presentationModule
import julien.vermet.techtest.presentation.features.details.DetailsViewModel
import julien.vermet.techtest.presentation.model.AlbumUI
import julien.vermet.techtest.remote.di.remoteModule
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.Test
import org.koin.core.context.GlobalContext.startKoin
import org.koin.core.parameter.parametersOf
import org.koin.dsl.module
import org.koin.test.KoinTest
import org.koin.test.check.checkModules

@OptIn(ExperimentalCoroutinesApi::class)
class KoinCheckModulesTest : KoinTest {

    @MockK
    private lateinit var application: Application
    private val dispatcher = StandardTestDispatcher()

    private val mockedApplicationModule = module {
        single { application }
        single<Context> { application }
    }

    @Before
    fun setup() {
        Dispatchers.setMain(dispatcher)
        MockKAnnotations.init(this, relaxed = true)
        every { application.getString(any()) } returns "http://test.com"
    }

    @Test
    fun verifyKoinApp() {
        startKoin {
            modules(mockedApplicationModule, presentationModule, domainModule, remoteModule, dataModule, cacheModule)
        }.checkModules {
            create<DetailsViewModel> { parametersOf(AlbumUI(0, 0, "title", "url", "thumbnailUrl")) }
        }
    }
}