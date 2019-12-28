package com.hitanshudhawan.popcorn2

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class GridLayoutMarginDecoration(
    private val verticalMargin: Int,
    private val horizontalMargin: Int,
    private val spanCount: Int
) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        val position = parent.getChildAdapterPosition(view)
        val row = position / spanCount
        val column = position % spanCount
        with(outRect) {
            if (row == 0)
                top = verticalMargin
            bottom = verticalMargin
            if (column == 0)
                left = horizontalMargin
            right = horizontalMargin
        }
    }

}
