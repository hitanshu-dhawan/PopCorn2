package com.hitanshudhawan.popcorn2

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class GridLayoutMarginDecoration(
    private val verticalMargin: Int,
    private val horizontalMargin: Int,
    private val spanCount: Int
) : RecyclerView.ItemDecoration() {

    // link : https://stackoverflow.com/a/30701422
    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        val position = parent.getChildAdapterPosition(view)
        with(outRect) {
            top = if (position < spanCount) verticalMargin else 0
            bottom = verticalMargin
            left = horizontalMargin - ((position % spanCount) * (horizontalMargin / spanCount))
            right = ((position % spanCount) + 1) * (horizontalMargin / spanCount)
        }
    }

}
