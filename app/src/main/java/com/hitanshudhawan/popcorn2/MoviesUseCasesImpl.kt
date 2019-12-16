package com.hitanshudhawan.popcorn2

import androidx.lifecycle.map


class MoviesUseCasesImpl(
    private val moviesRepository: MoviesRepository,
    private val genresRepository: GenresRepository
) : MoviesUseCases {

    override fun getNowPlayingMovies() = zip(moviesRepository.getNowPlayingMovies(), genresRepository.getMovieGenres()) { movieBriefs, genres ->
        getShowBannerData(movieBriefs, genres)
    }

    override fun getPopularMovies() = moviesRepository.getPopularMovies().map { movieBriefs ->
        getShowCardData(movieBriefs)
    }

    override fun getUpcomingMovies() = zip(moviesRepository.getUpcomingMovies(), genresRepository.getMovieGenres()) { movieBriefs, genres ->
        getShowBannerData(movieBriefs, genres)
    }

    override fun getTopRatedMovies() = moviesRepository.getTopRatedMovies().map { movieBriefs ->
        getShowCardData(movieBriefs)
    }

    private fun getShowBannerData(movieBriefs: Resource<List<MovieBrief>>, genres: Resource<List<Genre>>): Resource<List<ShowBannerData>> {
        if (movieBriefs is Resource.Success && genres is Resource.Success)
            return Resource.Success(movieBriefs.data.map { ShowBannerData(it.backdrop!!, it.title, it.rating, it.genreIds.map { id -> genres.data.find { id == it.id }!!.name }) })
        if (movieBriefs is Resource.Error || genres is Resource.Error)
            return Resource.Error()
        return Resource.Loading()
    }

    private fun getShowCardData(movieBriefs: Resource<List<MovieBrief>>): Resource<List<ShowCardData>> {
        if (movieBriefs is Resource.Success)
            return Resource.Success(movieBriefs.data.map { ShowCardData(it.poster!!, it.title) })
        if (movieBriefs is Resource.Error)
            return Resource.Error()
        return Resource.Loading()
    }

}