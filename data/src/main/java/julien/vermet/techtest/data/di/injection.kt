package julien.vermet.techtest.data.di

import julien.vermet.techtest.data.AlbumDataRepository
import julien.vermet.techtest.data.mapper.AlbumMapper
import julien.vermet.techtest.data.mapper.Mapper
import julien.vermet.techtest.data.repository.AlbumRemote
import julien.vermet.techtest.domain.repository.AlbumRepository
import org.koin.dsl.module

val dataModule = module {

    single<AlbumRepository> { AlbumDataRepository(albumRemote = get(), albumMapper = get()) }
    single<Mapper> { AlbumMapper() }

}