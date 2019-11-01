package com.hitanshudhawan.popcorn2.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.hitanshudhawan.popcorn2.adapters.MoviesLargeAdapter
import com.hitanshudhawan.popcorn2.adapters.MoviesSmallAdapter
import com.hitanshudhawan.popcorn2.databinding.FragmentMoviesBinding
import com.hitanshudhawan.popcorn2.viewmodels.MoviesViewModel

class MoviesFragment : Fragment() {

    private lateinit var binding: FragmentMoviesBinding

    private val moviesViewModel by lazy {
        ViewModelProviders.of(this).get(MoviesViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentMoviesBinding.inflate(inflater).also {
            it.vm = moviesViewModel
            it.lifecycleOwner = this
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // hitanshu : try to find a better solution for RecyclerView + Data Binding

        moviesViewModel.nowShowingMovies.observe(this, Observer {
            binding.recyclerViewNowShowing.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            binding.recyclerViewNowShowing.adapter = MoviesLargeAdapter(context!!, it)
        })

        moviesViewModel.popularMovies.observe(this, Observer {
            binding.recyclerViewPopular.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            binding.recyclerViewPopular.adapter = MoviesSmallAdapter(context!!, it)
        })

        moviesViewModel.upcomingMovies.observe(this, Observer {
            binding.recyclerViewUpcoming.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            binding.recyclerViewUpcoming.adapter = MoviesLargeAdapter(context!!, it)
        })

        moviesViewModel.topRatedMovies.observe(this, Observer {
            binding.recyclerViewTopRated.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            binding.recyclerViewTopRated.adapter = MoviesSmallAdapter(context!!, it)
        })
    }

}