package julien.vermet.techtest.presentation.di

import julien.vermet.techtest.presentation.arch.SchedulerProvider
import julien.vermet.techtest.presentation.features.details.DetailsViewModel
import julien.vermet.techtest.presentation.features.list.ListViewModel
import julien.vermet.techtest.presentation.model.AlbumUIMapper
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel {
        ListViewModel(
            fetchAlbumsUseCase = get(),
            albumUiMapper = get(),
            schedulerProvider = get()
        )
    }
    viewModel { parameters -> DetailsViewModel(album = parameters.get()) }
    factory { AlbumUIMapper() }
    single { SchedulerProvider() }
}