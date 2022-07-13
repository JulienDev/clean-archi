package julien.vermet.techtest.presentation.features.list

import julien.vermet.techtest.presentation.model.AlbumUI

sealed class ListState
object ListStateLoading : ListState()
data class ListStateReady(val albums : List<AlbumUI>) : ListState()
object ListStateError : ListState()
