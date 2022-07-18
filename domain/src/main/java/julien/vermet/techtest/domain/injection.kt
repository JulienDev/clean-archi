package julien.vermet.techtest.domain

import julien.vermet.techtest.domain.usecases.FetchAlbumsUseCase
import org.koin.dsl.module

val domainModule = module {
    factory { FetchAlbumsUseCase(albumRepository = get()) }
}