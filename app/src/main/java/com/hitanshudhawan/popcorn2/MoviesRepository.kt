package com.hitanshudhawan.popcorn2

class MoviesRepository(private val moviesService: MoviesService) {

    suspend fun getNowPlayingMovies(): List<MovieBrief> {
        return moviesService.getNowPlayingMovies().results
    }

    suspend fun getPopularMovies(): List<MovieBrief> {
        return moviesService.getPopularMovies().results
    }

    //...

}