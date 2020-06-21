package com.hitanshudhawan.popcorn2.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import com.afollestad.recyclical.datasource.dataSourceTypedOf
import com.afollestad.recyclical.itemdefinition.onChildViewClick
import com.afollestad.recyclical.setup
import com.afollestad.recyclical.withItem
import com.hitanshudhawan.popcorn2.*
import kotlinx.android.synthetic.main.fragment_movies.*
import org.koin.android.viewmodel.ext.android.viewModel

class MoviesFragment : Fragment() {

    private val moviesViewModel: MoviesViewModel by viewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_movies, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        moviesViewModel.moviesState.observe(viewLifecycleOwner, Observer {
            when (it) {
                is MoviesState.Success -> {
                    views.visibility = View.VISIBLE
                    progress_bar.visibility = View.GONE

                    now_playing_recycler_view.apply {
                        layoutManager = object : LinearLayoutManager(context, RecyclerView.HORIZONTAL, false) {
                            override fun checkLayoutParams(lp: RecyclerView.LayoutParams?): Boolean {
                                lp?.run { width = (getWidth() * 0.9).toInt() }
                                return true
                            }
                        }
                        addItemDecoration(LinearLayoutMarginDecoration(8.toPx(), 8.toPx(), RecyclerView.HORIZONTAL))
                        setup {
                            withDataSource(dataSourceTypedOf(it.nowPlayingMovies))
                            withItem<ShowData, ShowBannerViewHolder>(R.layout.item_show_banner) {
                                onBind(::ShowBannerViewHolder) { index, item ->
                                    backdrop.load("https://image.tmdb.org/t/p/w1280/${item.backdrop}")
                                    title.text = item.title
                                    rating.text = "${item.rating}*"
                                    genres.text = item.genres.joinToString { it.second }
                                    moviesViewModel.isFavoriteMovie(item.id).observe(this@MoviesFragment, Observer {
                                        favorite.setImageResource(if (it != null && it) R.mipmap.ic_favorite_black_18dp else R.mipmap.ic_favorite_border_black_18dp)
                                    })
                                }
                                onChildViewClick(ShowBannerViewHolder::favorite) { index, view ->
                                    moviesViewModel.toggleFavoriteMovie(item)
                                }
                            }
                        }
                    }
                    now_playing_view_all_text_view.setOnClickListener {
                        //...
                    }

                    popular_recycler_view.apply {
                        layoutManager = object : LinearLayoutManager(context, RecyclerView.HORIZONTAL, false) {
                            override fun checkLayoutParams(lp: RecyclerView.LayoutParams?): Boolean {
                                lp?.run { width = (getWidth() * 0.3).toInt() }
                                return true
                            }
                        }
                        addItemDecoration(LinearLayoutMarginDecoration(8.toPx(), 8.toPx(), RecyclerView.HORIZONTAL))
                        setup {
                            withDataSource(dataSourceTypedOf(it.popularMovies))
                            withItem<ShowData, ShowCardViewHolder>(R.layout.item_show_card) {
                                onBind(::ShowCardViewHolder) { index, item ->
                                    poster.load("https://image.tmdb.org/t/p/w1280/${item.poster}")
                                    title.text = item.title
                                    moviesViewModel.isFavoriteMovie(item.id).observe(this@MoviesFragment, Observer {
                                        favorite.setImageResource(if (it != null && it) R.mipmap.ic_favorite_black_18dp else R.mipmap.ic_favorite_border_black_18dp)
                                    })
                                }
                                onChildViewClick(ShowCardViewHolder::favorite) { index, view ->
                                    moviesViewModel.toggleFavoriteMovie(item)
                                }
                            }
                        }
                    }
                    popular_view_all_text_view.setOnClickListener {
                        //...
                    }

                    upcoming_recycler_view.apply {
                        layoutManager = object : LinearLayoutManager(context, RecyclerView.HORIZONTAL, false) {
                            override fun checkLayoutParams(lp: RecyclerView.LayoutParams?): Boolean {
                                lp?.run { width = (getWidth() * 0.9).toInt() }
                                return true
                            }
                        }
                        addItemDecoration(LinearLayoutMarginDecoration(8.toPx(), 8.toPx(), RecyclerView.HORIZONTAL))
                        setup {
                            withDataSource(dataSourceTypedOf(it.upcomingMovies))
                            withItem<ShowData, ShowBannerViewHolder>(R.layout.item_show_banner) {
                                onBind(::ShowBannerViewHolder) { index, item ->
                                    backdrop.load("https://image.tmdb.org/t/p/w1280/${item.backdrop}")
                                    title.text = item.title
                                    rating.text = "${item.rating}*"
                                    genres.text = item.genres.joinToString { it.second }
                                    moviesViewModel.isFavoriteMovie(item.id).observe(this@MoviesFragment, Observer {
                                        favorite.setImageResource(if (it != null && it) R.mipmap.ic_favorite_black_18dp else R.mipmap.ic_favorite_border_black_18dp)
                                    })
                                }
                                onChildViewClick(ShowBannerViewHolder::favorite) { index, view ->
                                    moviesViewModel.toggleFavoriteMovie(item)
                                }
                            }
                        }
                    }
                    upcoming_view_all_text_view.setOnClickListener {
                        //...
                    }

                    top_rated_recycler_view.apply {
                        layoutManager = object : LinearLayoutManager(context, RecyclerView.HORIZONTAL, false) {
                            override fun checkLayoutParams(lp: RecyclerView.LayoutParams?): Boolean {
                                lp?.run { width = (getWidth() * 0.3).toInt() }
                                return true
                            }
                        }
                        addItemDecoration(LinearLayoutMarginDecoration(8.toPx(), 8.toPx(), RecyclerView.HORIZONTAL))
                        setup {
                            withDataSource(dataSourceTypedOf(it.topRatedMovies))
                            withItem<ShowData, ShowCardViewHolder>(R.layout.item_show_card) {
                                onBind(::ShowCardViewHolder) { index, item ->
                                    poster.load("https://image.tmdb.org/t/p/w1280/${item.poster}")
                                    title.text = item.title
                                    moviesViewModel.isFavoriteMovie(item.id).observe(this@MoviesFragment, Observer {
                                        favorite.setImageResource(if (it != null && it) R.mipmap.ic_favorite_black_18dp else R.mipmap.ic_favorite_border_black_18dp)
                                    })
                                }
                                onChildViewClick(ShowCardViewHolder::favorite) { index, view ->
                                    moviesViewModel.toggleFavoriteMovie(item)
                                }
                            }
                        }
                    }
                    top_rated_view_all_text_view.setOnClickListener {
                        //...
                    }

                }
                is MoviesState.Error -> {
                    Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show()
                }
                is MoviesState.Loading -> {
                    views.visibility = View.GONE
                    progress_bar.visibility = View.VISIBLE
                }
            }
        })

    }

}
