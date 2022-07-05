package julien.vermet.techtest.presentation.di

import julien.vermet.techtest.presentation.details.DetailsViewModel
import julien.vermet.techtest.presentation.list.ListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel { ListViewModel() }
    viewModel { DetailsViewModel() }
}