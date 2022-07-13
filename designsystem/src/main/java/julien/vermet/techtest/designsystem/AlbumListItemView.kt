package julien.vermet.techtest.designsystem

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.ViewGroup
import coil.load
import com.google.android.material.card.MaterialCardView
import julien.vermet.techtest.designsystem.databinding.AlbumListItemBinding

class AlbumListItemView : MaterialCardView {

    private val layoutInflater = LayoutInflater.from(context)
    private val binding = AlbumListItemBinding.inflate(layoutInflater, this)

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    init {
        layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
    }

    fun setModel(model : AlbumListItemViewModel) {
        binding.itemImage.load(model.imageUrl)
        binding.itemTitle.text = model.title
    }

}