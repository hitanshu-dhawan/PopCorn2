package com.hitanshudhawan.popcorn2

import android.graphics.Rect
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import com.afollestad.recyclical.datasource.dataSourceTypedOf
import com.afollestad.recyclical.setup
import com.afollestad.recyclical.withItem
import kotlinx.android.synthetic.main.fragment_movies.*
import org.koin.android.viewmodel.ext.android.viewModel

class MoviesFragment : Fragment() {

    private val moviesViewModel: MoviesViewModel by viewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_movies, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        moviesViewModel.nowPlayingMovies.observe(viewLifecycleOwner, Observer {
            now_playing_recycler_view.apply {
                layoutManager = object : LinearLayoutManager(context, RecyclerView.HORIZONTAL, false) {
                    override fun checkLayoutParams(lp: RecyclerView.LayoutParams?): Boolean {
                        lp?.run { width = (getWidth() * 0.9).toInt() }
                        return true
                    }
                }
                addItemDecoration(object : RecyclerView.ItemDecoration() {
                    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
                        with(outRect) {
                            top = 8.toPx()
                            bottom = 8.toPx()
                            if (parent.getChildAdapterPosition(view) == 0)
                                left = 8.toPx()
                            right = 8.toPx()
                        }
                    }
                })
                setup {
                    withDataSource(dataSourceTypedOf(it.map { ShowBannerData(it.backdrop ?: "", it.title, it.rating, it.genres) }))
                    withItem<ShowBannerData, ShowBannerViewHolder>(R.layout.item_show_banner) {
                        onBind(::ShowBannerViewHolder) { index, item ->
                            backdrop.load("https://image.tmdb.org/t/p/w1280/${item.backdrop}")
                            title.text = item.title
                            rating.text = "${item.rating}*"
                            genres.text = item.genres.joinToString()
                            //...
                        }
                    }
                }
            }
        })
        moviesViewModel.popularMovies.observe(viewLifecycleOwner, Observer {
            popular_recycler_view.apply {
                layoutManager = object : LinearLayoutManager(context, RecyclerView.HORIZONTAL, false) {
                    override fun checkLayoutParams(lp: RecyclerView.LayoutParams?): Boolean {
                        lp?.run { width = (getWidth() * 0.3).toInt() }
                        return true
                    }
                }
                addItemDecoration(object : RecyclerView.ItemDecoration() {
                    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
                        with(outRect) {
                            top = 8.toPx()
                            bottom = 8.toPx()
                            if (parent.getChildAdapterPosition(view) == 0)
                                left = 8.toPx()
                            right = 8.toPx()
                        }
                    }
                })
                setup {
                    withDataSource(dataSourceTypedOf(it.map { ShowCardData(it.poster ?: "", it.title) }))
                    withItem<ShowCardData, ShowCardViewHolder>(R.layout.item_show_card) {
                        onBind(::ShowCardViewHolder) { index, item ->
                            poster.load("https://image.tmdb.org/t/p/w1280/${item.poster}")
                            title.text = item.title
                            //...
                        }
                    }
                }
            }
        })
        moviesViewModel.upcomingMovies.observe(viewLifecycleOwner, Observer {
            upcoming_recycler_view.apply {
                layoutManager = object : LinearLayoutManager(context, RecyclerView.HORIZONTAL, false) {
                    override fun checkLayoutParams(lp: RecyclerView.LayoutParams?): Boolean {
                        lp?.run { width = (getWidth() * 0.9).toInt() }
                        return true
                    }
                }
                addItemDecoration(object : RecyclerView.ItemDecoration() {
                    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
                        with(outRect) {
                            top = 8.toPx()
                            bottom = 8.toPx()
                            if (parent.getChildAdapterPosition(view) == 0)
                                left = 8.toPx()
                            right = 8.toPx()
                        }
                    }
                })
                setup {
                    withDataSource(dataSourceTypedOf(it.map { ShowBannerData(it.backdrop ?: "", it.title, it.rating, it.genres) }))
                    withItem<ShowBannerData, ShowBannerViewHolder>(R.layout.item_show_banner) {
                        onBind(::ShowBannerViewHolder) { index, item ->
                            backdrop.load("https://image.tmdb.org/t/p/w1280/${item.backdrop}")
                            title.text = item.title
                            rating.text = "${item.rating}*"
                            genres.text = item.genres.joinToString()
                            //...
                        }
                    }
                }
            }
        })
        moviesViewModel.topRatedMovies.observe(viewLifecycleOwner, Observer {
            top_rated_recycler_view.apply {
                layoutManager = object : LinearLayoutManager(context, RecyclerView.HORIZONTAL, false) {
                    override fun checkLayoutParams(lp: RecyclerView.LayoutParams?): Boolean {
                        lp?.run { width = (getWidth() * 0.3).toInt() }
                        return true
                    }
                }
                addItemDecoration(object : RecyclerView.ItemDecoration() {
                    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
                        with(outRect) {
                            top = 8.toPx()
                            bottom = 8.toPx()
                            if (parent.getChildAdapterPosition(view) == 0)
                                left = 8.toPx()
                            right = 8.toPx()
                        }
                    }
                })
                setup {
                    withDataSource(dataSourceTypedOf(it.map { ShowCardData(it.poster ?: "", it.title) }))
                    withItem<ShowCardData, ShowCardViewHolder>(R.layout.item_show_card) {
                        onBind(::ShowCardViewHolder) { index, item ->
                            poster.load("https://image.tmdb.org/t/p/w1280/${item.poster}")
                            title.text = item.title
                            //...
                        }
                    }
                }
            }
        })
    }

    //...

}
