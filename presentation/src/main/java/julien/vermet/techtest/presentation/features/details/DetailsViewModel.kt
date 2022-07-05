package julien.vermet.techtest.presentation.features.details

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import julien.vermet.techtest.presentation.model.AlbumUI

class DetailsViewModel(val album: AlbumUI) : ViewModel()