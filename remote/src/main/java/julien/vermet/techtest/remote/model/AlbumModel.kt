package julien.vermet.techtest.remote.model

import com.squareup.moshi.Json

data class AlbumModel(
    @Json(name = "albumId")
    val albumId: Int,

    @Json(name = "id")
    val id: Int,

    @Json(name = "title")
    val title: String,

    @Json(name = "url")
    val url: String,

    @Json(name = "thumbnailUrl")
    val thumbnailUrl: String
)
