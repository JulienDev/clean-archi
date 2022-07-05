package julien.vermet.techtest.domain.usecases

import io.reactivex.rxjava3.core.Single
import julien.vermet.techtest.domain.models.Album

class FetchAlbumsUseCase() {

    fun fetch() : Single<List<Album>> {
        return Single.just(
            listOf(
                Album("Title 1", "https://secure.gravatar.com/avatar/00fd156693c88a3bf2750d4de8e454c4?s=46&d=mm&r=g"),
                Album("Title 2", "https://secure.gravatar.com/avatar/00fd156693c88a3bf2750d4de8e454c4?s=46&d=mm&r=g"),
                Album("Title 3", "https://secure.gravatar.com/avatar/00fd156693c88a3bf2750d4de8e454c4?s=46&d=mm&r=g"),
                Album("Title 4", "https://secure.gravatar.com/avatar/00fd156693c88a3bf2750d4de8e454c4?s=46&d=mm&r=g"),
                Album("Title 5", "https://secure.gravatar.com/avatar/00fd156693c88a3bf2750d4de8e454c4?s=46&d=mm&r=g"),
                Album("Title 6", "https://secure.gravatar.com/avatar/00fd156693c88a3bf2750d4de8e454c4?s=46&d=mm&r=g"),
                Album("Title 7", "https://secure.gravatar.com/avatar/00fd156693c88a3bf2750d4de8e454c4?s=46&d=mm&r=g"),
                Album("Title 8", "https://secure.gravatar.com/avatar/00fd156693c88a3bf2750d4de8e454c4?s=46&d=mm&r=g"),
                Album("Title 9", "https://secure.gravatar.com/avatar/00fd156693c88a3bf2750d4de8e454c4?s=46&d=mm&r=g")
            )
        )
    }

}