package com.hitanshudhawan.popcorn2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import coil.api.load

class ViewAllMoviesAdapter : PagedListAdapter<MovieBrief, ShowCardViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShowCardViewHolder {
        return ShowCardViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_show_card, parent, false))
    }

    override fun onBindViewHolder(holder: ShowCardViewHolder, position: Int) {
        val item = getItem(position)!!

        holder.poster.load("https://image.tmdb.org/t/p/w1280/${item.poster}")
        holder.title.text = item.title
        //...
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<MovieBrief?>() {
            override fun areItemsTheSame(oldItem: MovieBrief, newItem: MovieBrief) = oldItem.id == newItem.id
            override fun areContentsTheSame(oldItem: MovieBrief, newItem: MovieBrief) = oldItem == newItem
        }
    }

}
