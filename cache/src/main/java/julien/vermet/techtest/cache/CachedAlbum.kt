package julien.vermet.techtest.cache

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "albums")
data class CachedAlbum(
    @ColumnInfo(name = "album_id")
    val albumId: Int,
    @PrimaryKey
    val id: Int,
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "url")
    val url: String,
    @ColumnInfo(name = "thumbnail_url")
    val thumbnailUrl: String
)