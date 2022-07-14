package julien.vermet.techtest.cache.mapper

import julien.vermet.techtest.cache.CachedAlbum
import julien.vermet.techtest.data.model.AlbumEntity

class AlbumEntityMapper : EntityMapper<CachedAlbum, AlbumEntity> {

    override fun mapToCached(type: AlbumEntity): CachedAlbum {
        return CachedAlbum(type.albumId, type.id, type.title, type.url, type.thumbnailUrl)
    }

    override fun mapFromCached(type: CachedAlbum): AlbumEntity {
        return AlbumEntity(type.albumId, type.id, type.title, type.url, type.thumbnailUrl)
    }

}