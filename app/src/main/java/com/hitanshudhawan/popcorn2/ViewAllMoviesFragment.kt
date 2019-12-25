package com.hitanshudhawan.popcorn2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs

class ViewAllMoviesFragment : Fragment() {

    private val args: ViewAllMoviesFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_view_all_movies, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Toast.makeText(context, args.moviesType.toString(), Toast.LENGTH_SHORT).show()
    }

    enum class MoviesType {
        NOW_PLAYING,
        POPULAR,
        UPCOMING,
        TOP_RATED
    }

}

// hitanshu : when pressing back from ViewAllMoviesFragment, MoviesFragment is created again! Find an elegant solution for this.
