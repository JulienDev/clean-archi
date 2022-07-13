package julien.vermet.techtest.designsystem

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import coil.load
import com.google.android.material.card.MaterialCardView
import julien.vermet.techtest.designsystem.databinding.AlbumListItemBinding
import julien.vermet.techtest.designsystem.databinding.EmptyViewBinding

class EmptyView : ConstraintLayout {

    private val layoutInflater = LayoutInflater.from(context)
    private val binding = EmptyViewBinding.inflate(layoutInflater, this)

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    constructor(
        context: Context,
        attrs: AttributeSet?,
        defStyleAttr: Int,
        defStyleRes: Int
    ) : super(context, attrs, defStyleAttr, defStyleRes)

    fun setModel(model : EmptyViewModel) {
        binding.emptyDescription.text = resources.getString(model.description)
        if (model.showRetry) {
            binding.emptyRetry.visible()
        } else {
            binding.emptyRetry.invisible()
        }
    }

    fun setOnRetryClickListener(clickListener : () -> Unit) {
        binding.emptyRetry.setOnClickListener {
            clickListener.invoke()
        }
    }

}