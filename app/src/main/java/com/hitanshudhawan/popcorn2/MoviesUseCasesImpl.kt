package com.hitanshudhawan.popcorn2

class MoviesUseCasesImpl(
    private val moviesRepository: MoviesRepository,
    private val genresRepository: GenresRepository
) : MoviesUseCases {

    override suspend fun getNowPlayingMovies(): Resource<List<ShowData>> {
        return getShowData(moviesRepository.getNowPlayingMovies(), genresRepository.getMovieGenres())
    }

    override suspend fun getPopularMovies(): Resource<List<ShowData>> {
        return getShowData(moviesRepository.getPopularMovies(), genresRepository.getMovieGenres())
    }

    override suspend fun getUpcomingMovies(): Resource<List<ShowData>> {
        return getShowData(moviesRepository.getUpcomingMovies(), genresRepository.getMovieGenres())
    }

    override suspend fun getTopRatedMovies(): Resource<List<ShowData>> {
        return getShowData(moviesRepository.getTopRatedMovies(), genresRepository.getMovieGenres())
    }

    private fun getShowData(movieBriefs: Resource<List<MovieBrief>>, genres: Resource<List<Genre>>): Resource<List<ShowData>> {
        if (movieBriefs is Resource.Success && genres is Resource.Success)
            return Resource.Success(movieBriefs.data.map { ShowData(it.id, it.title, it.poster ?: "", it.backdrop, it.rating, it.genreIds.map { id -> Pair(id, genres.data.find { id == it.id }!!.name) }) })
        if (movieBriefs is Resource.Error || genres is Resource.Error)
            return Resource.Error()
        return Resource.Loading()
    }

}
