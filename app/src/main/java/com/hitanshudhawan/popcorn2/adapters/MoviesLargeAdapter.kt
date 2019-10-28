package com.hitanshudhawan.popcorn2.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hitanshudhawan.popcorn2.viewmodels.MovieCardViewModel
import com.hitanshudhawan.popcorn2.databinding.ItemMovieLargeCardBinding
import com.hitanshudhawan.popcorn2.network.models.Movie

class MoviesLargeAdapter(private val context: Context, private val movies: List<Movie>) : RecyclerView.Adapter<MoviesLargeAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemMovieLargeCardBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.vm = MovieCardViewModel(movies[position])
        holder.binding.executePendingBindings()
    }

    override fun getItemCount() = movies.size

    inner class ViewHolder(val binding: ItemMovieLargeCardBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.imageLayoutMovieCard.layoutParams.width = (context.resources.displayMetrics.widthPixels * 0.9).toInt()
            binding.imageLayoutMovieCard.layoutParams.height = ((context.resources.displayMetrics.widthPixels * 0.9) / 1.77).toInt()
        }
    }
}