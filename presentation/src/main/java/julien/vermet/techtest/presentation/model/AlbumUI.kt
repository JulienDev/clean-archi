package julien.vermet.techtest.presentation.model

import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.parcelize.Parcelize

@Keep
@Parcelize
data class AlbumUI(
    val albumId: Int,
    val id: Int,
    val title: String,
    val url: String,
    val thumbnailUrl: String
) : Parcelable

fun AlbumUI.getTransitionName() = "hero_image_${id}"