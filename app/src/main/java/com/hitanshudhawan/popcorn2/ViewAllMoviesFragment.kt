package com.hitanshudhawan.popcorn2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.fragment_view_all_movies.*
import org.koin.android.viewmodel.ext.android.viewModel

class ViewAllMoviesFragment : Fragment() {

    private val args: ViewAllMoviesFragmentArgs by navArgs()
    private val viewAllMoviesViewModel: ViewAllMoviesViewModel by viewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_view_all_movies, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Toast.makeText(context, args.moviesType.toString(), Toast.LENGTH_SHORT).show()

        view_all_recycler_view.apply {
            layoutManager = GridLayoutManager(context, 3)
            adapter = ViewAllMoviesAdapter()
        }
        viewAllMoviesViewModel.getPaginatedMovieBriefs().observe(this, Observer {
            (view_all_recycler_view.adapter as ViewAllMoviesAdapter).submitList(it)
        })

    }

    enum class MoviesType {
        NOW_PLAYING,
        POPULAR,
        UPCOMING,
        TOP_RATED
    }

}

// hitanshu : when pressing back from ViewAllMoviesFragment, MoviesFragment is created again! Find an elegant solution for this.

// hitanshu : Christmas : todo
// 1. Swipe to Refresh for MoviesFragment
// 2. Paging for ViewAllMoviesFragment with network and database both
// 3. Custom caching strategy for GenresRepository
