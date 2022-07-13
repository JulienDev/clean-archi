package julien.vermet.techtest.presentation.mapper

interface Mapper<out V, in D>  {

    fun mapToUI(type: D): V

}