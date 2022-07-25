package julien.vermet.techtest.presentation.features.list

import android.util.Log
import androidx.lifecycle.*
import julien.vermet.techtest.domain.models.Album
import julien.vermet.techtest.domain.usecases.FetchAlbumsUseCase
import julien.vermet.techtest.presentation.arch.Event
import julien.vermet.techtest.presentation.mapper.Mapper
import julien.vermet.techtest.presentation.model.AlbumUI
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class ListViewModel(
    private val fetchAlbumsUseCase: FetchAlbumsUseCase,
    private val mapper: Mapper<AlbumUI, Album>
) : ViewModel(), DefaultLifecycleObserver {

    private val _listStateLiveData = MutableLiveData<ListState>()
    val listStateLiveData: LiveData<ListState>
        get() = _listStateLiveData

    private val _showAlbumDetailsEvent = MutableLiveData<Event<AlbumUI>>()
    val showAlbumDetailsEvent: LiveData<Event<AlbumUI>>
        get() = _showAlbumDetailsEvent

    fun onAlbumSelected(album: AlbumUI) {
        _showAlbumDetailsEvent.value = Event(album)
    }

    fun onRetryClick() {
        loadAlbums()
    }

    init {
        loadAlbums()
    }

    private fun loadAlbums() {
        viewModelScope.launch {
            fetchAlbumsUseCase.fetch()
                .onStart { _listStateLiveData.value = ListStateLoading }
                .map { albums -> albums.map { album -> mapper.mapToUI(album) } }
                .onEach { albums -> _listStateLiveData.value = ListStateReady(albums) }
                .catch { _listStateLiveData.value = ListStateError }
                .collect()
        }
    }

}