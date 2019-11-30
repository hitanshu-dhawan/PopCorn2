package com.hitanshudhawan.popcorn2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.android.ext.android.inject

class MoviesFragment : Fragment() {

    private val moviesService: MoviesService by inject()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_movies, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        GlobalScope.launch(Dispatchers.IO) {

            val a = moviesService.getNowPlayingMovies()
            val b = moviesService.getPopularMovies()
            val c = moviesService.getUpcomingMovies()
            val d = moviesService.getTopRatedMovies()

            withContext(Dispatchers.Main) {
                Toast.makeText(this@MoviesFragment.context, "${(a.results + b.results + c.results + d.results).size}", Toast.LENGTH_SHORT).show()
            }

        }
    }

}
