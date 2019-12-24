package com.hitanshudhawan.popcorn2

import androidx.lifecycle.LiveData

class MoviesUseCasesImpl(
    private val moviesRepository: MoviesRepository,
    private val genresRepository: GenresRepository
) : MoviesUseCases {

    override fun getNowPlayingMovies(): LiveData<Resource<List<ShowData>>> {
        return zip(moviesRepository.getNowPlayingMovies(), genresRepository.getMovieGenres()) { movieBriefs, genres ->
            getShowData(movieBriefs, genres)
        }
    }

    override fun getPopularMovies(): LiveData<Resource<List<ShowData>>> {
        return zip(moviesRepository.getPopularMovies(), genresRepository.getMovieGenres()) { movieBriefs, genres ->
            getShowData(movieBriefs, genres)
        }
    }

    override fun getUpcomingMovies(): LiveData<Resource<List<ShowData>>> {
        return zip(moviesRepository.getUpcomingMovies(), genresRepository.getMovieGenres()) { movieBriefs, genres ->
            getShowData(movieBriefs, genres)
        }
    }

    override fun getTopRatedMovies(): LiveData<Resource<List<ShowData>>> {
        return zip(moviesRepository.getTopRatedMovies(), genresRepository.getMovieGenres()) { movieBriefs, genres ->
            getShowData(movieBriefs, genres)
        }
    }

    private fun getShowData(movieBriefs: Resource<List<MovieBrief>>, genres: Resource<List<Genre>>): Resource<List<ShowData>> {
        if (movieBriefs is Resource.Success && genres is Resource.Success)
            return Resource.Success(movieBriefs.data.map { ShowData(it.id, it.title, it.poster ?: "", it.backdrop, it.rating, it.genreIds.map { id -> Pair(id, genres.data.find { id == it.id }!!.name) }) })
        if (movieBriefs is Resource.Error || genres is Resource.Error)
            return Resource.Error()
        return Resource.Loading()
    }

}
