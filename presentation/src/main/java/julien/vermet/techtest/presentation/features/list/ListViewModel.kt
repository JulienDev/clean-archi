package julien.vermet.techtest.presentation.features.list

import android.util.Log
import androidx.lifecycle.*
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.kotlin.subscribeBy
import julien.vermet.techtest.domain.usecases.FetchAlbumsUseCase
import julien.vermet.techtest.presentation.arch.Event
import julien.vermet.techtest.presentation.arch.SchedulerProvider
import julien.vermet.techtest.presentation.model.AlbumUI
import julien.vermet.techtest.presentation.model.AlbumUIMapper

class ListViewModel(
    private val fetchAlbumsUseCase: FetchAlbumsUseCase,
    private val albumUiMapper : AlbumUIMapper,
    private val schedulerProvider: SchedulerProvider,
) : ViewModel(), DefaultLifecycleObserver {

    private val _albumsLiveData = MutableLiveData<List<AlbumUI>>()
    val albumsLiveData: LiveData<List<AlbumUI>>
        get() = _albumsLiveData

    private val _showAlbumDetailsEvent = MutableLiveData<Event<AlbumUI>>()
    val showAlbumDetailsEvent : LiveData<Event<AlbumUI>>
        get() = _showAlbumDetailsEvent

    private var fetchToAlbumsSubscription : Disposable? = null

    override fun onCreate(owner: LifecycleOwner) {
        super.onCreate(owner)
        Log.e("listviewmodel", "onCreate")

        fetchToAlbumsSubscription = subscribeToFetchAlbums()

    }

    fun onAlbumSelected(album : AlbumUI) {
        _showAlbumDetailsEvent.value = Event(album)
    }

    private fun subscribeToFetchAlbums() : Disposable {
        return fetchAlbumsUseCase.fetch()
            .subscribeOn(schedulerProvider.io())
            .map { albums -> albumUiMapper.map(albums) }
            .observeOn(schedulerProvider.ui())
            .subscribeBy(onSuccess = { albums ->
                _albumsLiveData.value = albums
            }, onError = {

            })
    }

}