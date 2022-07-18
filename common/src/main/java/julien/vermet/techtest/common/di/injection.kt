package julien.vermet.techtest.common.di

import julien.vermet.techtest.common.BaseSchedulerProvider
import julien.vermet.techtest.common.SchedulerProvider
import org.koin.dsl.module

val commonModule = module {

    single<BaseSchedulerProvider> { SchedulerProvider() }

}