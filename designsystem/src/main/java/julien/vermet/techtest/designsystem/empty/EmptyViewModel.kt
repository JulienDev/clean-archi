package julien.vermet.techtest.designsystem.empty

import androidx.annotation.StringRes

data class EmptyViewModel(
    @StringRes val description: Int,
    val showRetry : Boolean = false
)