package julien.vermet.techtest.presentation.di

import julien.vermet.techtest.common.SchedulerProvider
import julien.vermet.techtest.domain.models.Album
import julien.vermet.techtest.presentation.features.details.DetailsViewModel
import julien.vermet.techtest.presentation.features.list.ListViewModel
import julien.vermet.techtest.presentation.mapper.AlbumMapper
import julien.vermet.techtest.presentation.mapper.Mapper
import julien.vermet.techtest.presentation.model.AlbumUI
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel {
        ListViewModel(
            fetchAlbumsUseCase = get(),
            mapper = get(),
            schedulerProvider = get()
        )
    }
    viewModel { parameters -> DetailsViewModel(album = parameters.get()) }
    factory<Mapper<AlbumUI, Album>> { AlbumMapper() }
    single { SchedulerProvider() }
}