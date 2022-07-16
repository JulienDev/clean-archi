package julien.vermet.techtest.designsystem.empty

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import julien.vermet.techtest.designsystem.databinding.EmptyViewBinding
import julien.vermet.techtest.designsystem.extensions.invisible
import julien.vermet.techtest.designsystem.extensions.visible

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