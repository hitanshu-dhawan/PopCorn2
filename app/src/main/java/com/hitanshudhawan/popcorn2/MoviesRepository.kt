package com.hitanshudhawan.popcorn2

class MoviesRepository(private val moviesService: MoviesService) {

    suspend fun getNowPlayingMovies(): List<MovieBriefJson> {
        return moviesService.getNowPlayingMovies().results
    }

    suspend fun getPopularMovies(): List<MovieBriefJson> {
        return moviesService.getPopularMovies().results
    }

    //...

}