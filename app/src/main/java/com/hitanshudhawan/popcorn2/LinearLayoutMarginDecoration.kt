package com.hitanshudhawan.popcorn2

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

// hitanshu : write documentation
class LinearLayoutMarginDecoration(
    private val verticalMargin: Int,
    private val horizontalMargin: Int,
    @RecyclerView.Orientation
    private val orientation: Int = RecyclerView.VERTICAL
) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        when (orientation) {
            RecyclerView.VERTICAL -> {
                val position = parent.getChildAdapterPosition(view)
                with(outRect) {
                    if (position == 0)
                        top = verticalMargin
                    bottom = verticalMargin
                    left = horizontalMargin
                    right = horizontalMargin
                }
            }
            RecyclerView.HORIZONTAL -> {
                val position = parent.getChildAdapterPosition(view)
                with(outRect) {
                    top = verticalMargin
                    bottom = verticalMargin
                    if (position == 0)
                        left = horizontalMargin
                    right = horizontalMargin
                }
            }
        }
    }

}