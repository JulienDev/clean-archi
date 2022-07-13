package julien.vermet.techtest.designsystem.utils

import android.content.Context
import android.graphics.Rect
import android.view.View
import androidx.annotation.DimenRes
import androidx.recyclerview.widget.RecyclerView

class GridSpacingDecoration(
    context: Context,
    @DimenRes private val itemOffsetId: Int
) : RecyclerView.ItemDecoration() {

    private val offset = context.resources.getDimensionPixelSize(itemOffsetId)

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect.set(offset, offset, offset, offset)
    }

}