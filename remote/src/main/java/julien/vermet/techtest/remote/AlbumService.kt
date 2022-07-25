package julien.vermet.techtest.remote

import julien.vermet.techtest.remote.model.AlbumModel
import retrofit2.http.GET

interface AlbumService {
  @GET("img/shared/technical-test.json")
  suspend fun getAlbums(): List<AlbumModel>
}