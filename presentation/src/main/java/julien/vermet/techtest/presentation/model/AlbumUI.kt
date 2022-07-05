package julien.vermet.techtest.presentation.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class AlbumUI(
    val title : String,
    val imageUrl : String
) : Parcelable