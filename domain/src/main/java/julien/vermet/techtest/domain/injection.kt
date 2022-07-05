package julien.vermet.techtest.domain

import julien.vermet.techtest.domain.usecases.FetchAlbumsUseCase
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val domainModule = module {
    factory { FetchAlbumsUseCase() }
}