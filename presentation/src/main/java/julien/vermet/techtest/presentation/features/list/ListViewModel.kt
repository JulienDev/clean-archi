package julien.vermet.techtest.presentation.features.list

import android.util.Log
import androidx.lifecycle.*
import julien.vermet.techtest.presentation.arch.Event
import julien.vermet.techtest.presentation.model.AlbumUI

class ListViewModel : ViewModel(), DefaultLifecycleObserver {

    private val _albumsLiveData = MutableLiveData<List<AlbumUI>>()
    val albumsLiveData: LiveData<List<AlbumUI>>
        get() = _albumsLiveData

    private val _showAlbumDetailsEvent = MutableLiveData<Event<AlbumUI>>()
    val showAlbumDetailsEvent : LiveData<Event<AlbumUI>>
        get() = _showAlbumDetailsEvent

    override fun onCreate(owner: LifecycleOwner) {
        super.onCreate(owner)
        Log.e("listviewmodel", "onCreate")

        _albumsLiveData.value = listOf(
            AlbumUI("Title 1", "https://secure.gravatar.com/avatar/00fd156693c88a3bf2750d4de8e454c4?s=46&d=mm&r=g"),
            AlbumUI("Title 2", "https://secure.gravatar.com/avatar/00fd156693c88a3bf2750d4de8e454c4?s=46&d=mm&r=g"),
            AlbumUI("Title 3", "https://secure.gravatar.com/avatar/00fd156693c88a3bf2750d4de8e454c4?s=46&d=mm&r=g"),
            AlbumUI("Title 4", "https://secure.gravatar.com/avatar/00fd156693c88a3bf2750d4de8e454c4?s=46&d=mm&r=g"),
            AlbumUI("Title 5", "https://secure.gravatar.com/avatar/00fd156693c88a3bf2750d4de8e454c4?s=46&d=mm&r=g"),
            AlbumUI("Title 6", "https://secure.gravatar.com/avatar/00fd156693c88a3bf2750d4de8e454c4?s=46&d=mm&r=g"),
            AlbumUI("Title 7", "https://secure.gravatar.com/avatar/00fd156693c88a3bf2750d4de8e454c4?s=46&d=mm&r=g"),
            AlbumUI("Title 8", "https://secure.gravatar.com/avatar/00fd156693c88a3bf2750d4de8e454c4?s=46&d=mm&r=g"),
            AlbumUI("Title 9", "https://secure.gravatar.com/avatar/00fd156693c88a3bf2750d4de8e454c4?s=46&d=mm&r=g")
        )
    }

    fun onAlbumSelected(album : AlbumUI) {
        _showAlbumDetailsEvent.value = Event(album)
    }
}