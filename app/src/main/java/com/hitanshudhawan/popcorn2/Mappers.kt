package com.hitanshudhawan.popcorn2

import com.hitanshudhawan.popcorn2.database.cache.CacheMovieGenreEntity
import com.hitanshudhawan.popcorn2.database.cache.CacheNowPlayingMovieBriefEntity
import com.hitanshudhawan.popcorn2.database.cache.CachePopularMovieBriefEntity
import com.hitanshudhawan.popcorn2.database.cache.CacheTVShowGenreEntity
import com.hitanshudhawan.popcorn2.database.cache.CacheTopRatedMovieBriefEntity
import com.hitanshudhawan.popcorn2.database.cache.CacheUpcomingMovieBriefEntity
import com.hitanshudhawan.popcorn2.network.models.GenresJson
import com.hitanshudhawan.popcorn2.network.models.MoviesJson


/**
 * Movies
 */

@JvmName("mapMoviesJsonToMovieBriefs")
fun MoviesJson.mapToMovieBriefs(): List<MovieBrief> {
    return this.results.mapIndexed { index, it -> MovieBrief(page, index, it.id, it.title, it.poster_path, it.backdrop_path, it.vote_average, it.genre_ids) }
}

@JvmName("mapMovieBriefsToNowPlayingMovieBriefEntities")
fun List<MovieBrief>.mapToNowPlayingMovieBriefEntities(): List<CacheNowPlayingMovieBriefEntity> {
    return this.map { CacheNowPlayingMovieBriefEntity(it.page, it.index, it.id, it.title, it.poster, it.backdrop, it.rating, it.genreIds) }
}

@JvmName("mapMovieBriefsToPopularMovieBriefEntities")
fun List<MovieBrief>.mapToPopularMovieBriefEntities(): List<CachePopularMovieBriefEntity> {
    return this.map { CachePopularMovieBriefEntity(it.page, it.index, it.id, it.title, it.poster, it.backdrop, it.rating, it.genreIds) }
}

@JvmName("mapMovieBriefsToUpcomingMovieBriefEntities")
fun List<MovieBrief>.mapToUpcomingMovieBriefEntities(): List<CacheUpcomingMovieBriefEntity> {
    return this.map { CacheUpcomingMovieBriefEntity(it.page, it.index, it.id, it.title, it.poster, it.backdrop, it.rating, it.genreIds) }
}

@JvmName("mapMovieBriefsToTopRatedMovieBriefEntities")
fun List<MovieBrief>.mapToTopRatedMovieBriefEntities(): List<CacheTopRatedMovieBriefEntity> {
    return this.map { CacheTopRatedMovieBriefEntity(it.page, it.index, it.id, it.title, it.poster, it.backdrop, it.rating, it.genreIds) }
}

@JvmName("mapNowPlayingMovieBriefEntitiesToMovieBriefs")
fun List<CacheNowPlayingMovieBriefEntity>.mapToMovieBriefs(): List<MovieBrief> {
    return this.map { MovieBrief(it.page, it.index, it.id, it.title, it.poster, it.backdrop, it.rating, it.genreIds) }
}

@JvmName("mapPopularMovieBriefEntitiesToMovieBriefs")
fun List<CachePopularMovieBriefEntity>.mapToMovieBriefs(): List<MovieBrief> {
    return this.map { MovieBrief(it.page, it.index, it.id, it.title, it.poster, it.backdrop, it.rating, it.genreIds) }
}

@JvmName("mapUpcomingMovieBriefEntitiesToMovieBriefs")
fun List<CacheUpcomingMovieBriefEntity>.mapToMovieBriefs(): List<MovieBrief> {
    return this.map { MovieBrief(it.page, it.index, it.id, it.title, it.poster, it.backdrop, it.rating, it.genreIds) }
}

@JvmName("mapTopRatedMovieBriefEntitiesToMovieBriefs")
fun List<CacheTopRatedMovieBriefEntity>.mapToMovieBriefs(): List<MovieBrief> {
    return this.map { MovieBrief(it.page, it.index, it.id, it.title, it.poster, it.backdrop, it.rating, it.genreIds) }
}


/**
 * Genres
 */

@JvmName("mapGenresJsonToGenres")
fun GenresJson.mapToGenres(): List<Genre> {
    return this.genres.map { Genre(it.id, it.name) }
}

@JvmName("mapGenresToMovieGenreEntities")
fun List<Genre>.mapToMovieGenreEntities(): List<CacheMovieGenreEntity> {
    return this.map { CacheMovieGenreEntity(it.id, it.name) }
}

@JvmName("mapGenresToTVShowGenreEntities")
fun List<Genre>.mapToTVShowGenreEntities(): List<CacheTVShowGenreEntity> {
    return this.map { CacheTVShowGenreEntity(it.id, it.name) }
}

@JvmName("mapMovieGenreEntitiesToGenres")
fun List<CacheMovieGenreEntity>.mapToGenres(): List<Genre> {
    return this.map { Genre(it.id, it.name) }
}

@JvmName("mapTVShowGenreEntitiesToGenres")
fun List<CacheTVShowGenreEntity>.mapToGenres(): List<Genre> {
    return this.map { Genre(it.id, it.name) }
}
