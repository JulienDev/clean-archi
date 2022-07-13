package julien.vermet.techtest.remote.mapper

interface EntityMapper<in M, out E>  {

    fun mapFromRemote(model: M): E

}