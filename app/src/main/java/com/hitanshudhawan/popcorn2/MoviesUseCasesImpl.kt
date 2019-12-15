package com.hitanshudhawan.popcorn2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData

class MoviesUseCasesImpl(
    private val moviesRepository: MoviesRepository,
    private val genresRepository: GenresRepository
) : MoviesUseCases {

    override fun getNowPlayingMovies(): LiveData<Resource<List<ShowBannerData>>> {
        val movieBriefsLiveData = moviesRepository.getNowPlayingMovies()
        val genresLiveData = genresRepository.getMovieGenres()

        val showBannersLiveData = MediatorLiveData<Resource<List<ShowBannerData>>>()

        showBannersLiveData.addSource(movieBriefsLiveData) {
            showBannersLiveData.value = getShowBannerData(movieBriefsLiveData, genresLiveData)
        }
        showBannersLiveData.addSource(genresLiveData) {
            showBannersLiveData.value = getShowBannerData(movieBriefsLiveData, genresLiveData)
        }

        return showBannersLiveData
    }

    override fun getPopularMovies(): LiveData<Resource<List<ShowCardData>>> {
        val movieBriefsLiveData = moviesRepository.getPopularMovies()
        val genresLiveData = genresRepository.getMovieGenres()

        val showCardsLiveData = MediatorLiveData<Resource<List<ShowCardData>>>()

        showCardsLiveData.addSource(movieBriefsLiveData) {
            showCardsLiveData.value = getShowCardData(movieBriefsLiveData, genresLiveData)
        }
        showCardsLiveData.addSource(genresLiveData) {
            showCardsLiveData.value = getShowCardData(movieBriefsLiveData, genresLiveData)
        }

        return showCardsLiveData
    }

    private fun getShowBannerData(movieBriefsLiveData: LiveData<Resource<List<MovieBrief>>>, genresLiveData: LiveData<Resource<List<Genre>>>): Resource<List<ShowBannerData>> {
        val movieBriefs = movieBriefsLiveData.value
        val genres = genresLiveData.value
        if (movieBriefs != null && genres != null) {
            if (movieBriefs is Resource.Success && genres is Resource.Success) {
                return Resource.Success(movieBriefs.data.map { ShowBannerData(it.backdrop!!, it.title, it.rating, it.genreIds.map { id -> genres.data.find { id == it.id }!!.name }) }) //todo
            }
            if (movieBriefs is Resource.Error || genres is Resource.Error) {
                return Resource.Error()
            }
        }
        return Resource.Loading()
    }

    // hitanshu : genresLiveData is not required
    private fun getShowCardData(movieBriefsLiveData: LiveData<Resource<List<MovieBrief>>>, genresLiveData: LiveData<Resource<List<Genre>>>): Resource<List<ShowCardData>> {
        val movieBriefs = movieBriefsLiveData.value
        val genres = genresLiveData.value
        if (movieBriefs != null && genres != null) {
            if (movieBriefs is Resource.Success && genres is Resource.Success) {
                return Resource.Success(movieBriefs.data.map { ShowCardData(it.poster!!, it.title) }) //todo
            }
            if (movieBriefs is Resource.Error || genres is Resource.Error) {
                return Resource.Error()
            }
        }
        return Resource.Loading()
    }

}