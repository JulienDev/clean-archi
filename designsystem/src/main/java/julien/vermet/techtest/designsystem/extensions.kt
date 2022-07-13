package julien.vermet.techtest.designsystem

import android.view.View

fun View.visible() = run { visibility = View.VISIBLE }
fun View.invisible() = run { visibility = View.INVISIBLE }
fun View.gone() = run { visibility = View.GONE }