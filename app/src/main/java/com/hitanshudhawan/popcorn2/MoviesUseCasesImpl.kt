package com.hitanshudhawan.popcorn2

import androidx.lifecycle.liveData

class MoviesUseCasesImpl(
    private val moviesRepository: MoviesRepository,
    private val genresRepository: GenresRepository
) : MoviesUseCases {

    override fun getNowPlayingMovies() = liveData {
        emit(Resource.Loading())
        emit(getShowData(moviesRepository.getNowPlayingMovies(), genresRepository.getMovieGenres()))
    }

    override fun getPopularMovies() = liveData {
        emit(Resource.Loading())
        emit(getShowData(moviesRepository.getPopularMovies(), genresRepository.getMovieGenres()))
    }

    override fun getUpcomingMovies() = liveData {
        emit(Resource.Loading())
        emit(getShowData(moviesRepository.getUpcomingMovies(), genresRepository.getMovieGenres()))
    }

    override fun getTopRatedMovies() = liveData {
        emit(Resource.Loading())
        emit(getShowData(moviesRepository.getTopRatedMovies(), genresRepository.getMovieGenres()))
    }

    private fun getShowData(movieBriefs: Resource<List<MovieBrief>>, genres: Resource<List<Genre>>): Resource<List<ShowData>> {
        if (movieBriefs is Resource.Success && genres is Resource.Success)
            return Resource.Success(movieBriefs.data.map { ShowData(it.id, it.title, it.poster ?: "", it.backdrop, it.rating, it.genreIds.map { id -> Pair(id, genres.data.find { id == it.id }!!.name) }) })
        if (movieBriefs is Resource.Error || genres is Resource.Error)
            return Resource.Error()
        return Resource.Loading()
    }

    override fun isFavoriteMovie(id: Int) = moviesRepository.isFavoriteMovie(id)

    override suspend fun toggleFavoriteMovie(showData: ShowData) {
        //todo : 0, 0,
        moviesRepository.toggleFavoriteMovie(MovieBrief(0, 0, showData.id, showData.title, showData.poster, showData.backdrop, showData.rating, showData.genres.map { it.first }))
    }

}
