package com.hitanshudhawan.popcorn2

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.afollestad.recyclical.ViewHolder

class ShowCardViewHolder(itemView: View) : ViewHolder(itemView) {
    val poster = itemView.findViewById<ImageView>(R.id.poster_image_view)
    val title = itemView.findViewById<TextView>(R.id.title_text_view)
    val favorite = itemView.findViewById<ImageView>(R.id.favorite_image_view)
}