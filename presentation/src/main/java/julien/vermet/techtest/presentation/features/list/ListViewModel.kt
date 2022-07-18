package julien.vermet.techtest.presentation.features.list

import androidx.lifecycle.*
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.subjects.PublishSubject
import julien.vermet.techtest.common.BaseSchedulerProvider
import julien.vermet.techtest.domain.models.Album
import julien.vermet.techtest.domain.usecases.FetchAlbumsUseCase
import julien.vermet.techtest.presentation.arch.Event
import julien.vermet.techtest.presentation.mapper.Mapper
import julien.vermet.techtest.presentation.model.AlbumUI

class ListViewModel(
    private val fetchAlbumsUseCase: FetchAlbumsUseCase,
    private val mapper: Mapper<AlbumUI, Album>,
    private val schedulerProvider: BaseSchedulerProvider
) : ViewModel(), DefaultLifecycleObserver {

    private val _listStateLiveData = MutableLiveData<ListState>()
    val listStateLiveData: LiveData<ListState>
        get() = _listStateLiveData

    private val _showAlbumDetailsEvent = MutableLiveData<Event<AlbumUI>>()
    val showAlbumDetailsEvent: LiveData<Event<AlbumUI>>
        get() = _showAlbumDetailsEvent

    private val retrySubject = PublishSubject.create<Unit>()

    private var fetchToAlbumsSubscription: Disposable? = null

    override fun onCreate(owner: LifecycleOwner) {
        super.onCreate(owner)
        fetchToAlbumsSubscription = subscribeToFetchAlbums()
    }

    fun onAlbumSelected(album: AlbumUI) {
        _showAlbumDetailsEvent.value = Event(album)
    }

    fun onRetryClick() {
        retrySubject.onNext(Unit)
    }

    private fun subscribeToFetchAlbums(): Disposable {
        return retrySubject
            .startWithItem(Unit)
            .doOnNext { _listStateLiveData.value = ListStateLoading }
            .flatMapCompletable {
                fetchAlbumsUseCase.fetch()
                    .map { albums -> albums.map { album -> mapper.mapToUI(album) } }
                    .observeOn(schedulerProvider.ui())
                    .doOnSuccess { albums -> _listStateLiveData.value = ListStateReady(albums) }
                    .ignoreElement()
                    .onErrorResumeNext {
                        _listStateLiveData.value = ListStateError
                        Completable.complete()
                    }
            }
            .subscribe()
    }

}