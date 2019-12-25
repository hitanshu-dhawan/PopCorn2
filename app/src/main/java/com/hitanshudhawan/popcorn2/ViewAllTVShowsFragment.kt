package com.hitanshudhawan.popcorn2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs

class ViewAllTVShowsFragment : Fragment() {

    private val args: ViewAllTVShowsFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_view_all_tv_shows, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Toast.makeText(context, args.tvShowsType.toString(), Toast.LENGTH_SHORT).show()
    }

    enum class TVShowsType {
        AIRING_TODAY,
        ON_THE_AIR,
        POPULAR,
        TOP_RATED,
    }

}
