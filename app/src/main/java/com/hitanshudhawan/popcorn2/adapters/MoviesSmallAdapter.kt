package com.hitanshudhawan.popcorn2.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hitanshudhawan.popcorn2.viewmodels.MovieCardViewModel
import com.hitanshudhawan.popcorn2.databinding.ItemMovieSmallCardBinding
import com.hitanshudhawan.popcorn2.network.models.Movie

class MoviesSmallAdapter(private val context: Context, private val movies: List<Movie>) : RecyclerView.Adapter<MoviesSmallAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemMovieSmallCardBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.vm = MovieCardViewModel(movies[position])
        holder.binding.executePendingBindings()
    }

    override fun getItemCount() = movies.size

    inner class ViewHolder(val binding: ItemMovieSmallCardBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.imageViewMovieCard.layoutParams.width = (context.resources.displayMetrics.widthPixels * 0.31).toInt()
            binding.imageViewMovieCard.layoutParams.height = ((context.resources.displayMetrics.widthPixels * 0.31) / 0.66).toInt()
        }
    }
}