package com.hitanshudhawan.popcorn2

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.afollestad.recyclical.ViewHolder

class ShowBannerViewHolder(itemView: View) : ViewHolder(itemView) {
    val backdrop = itemView.findViewById<ImageView>(R.id.backdrop_image_view)!!
    val title = itemView.findViewById<TextView>(R.id.title_text_view)!!
    val rating = itemView.findViewById<TextView>(R.id.rating_text_view)!!
    val genres = itemView.findViewById<TextView>(R.id.genres_text_view)!!
    val favorite = itemView.findViewById<ImageView>(R.id.favorite_image_view)!!
}