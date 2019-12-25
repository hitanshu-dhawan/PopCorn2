package com.hitanshudhawan.popcorn2

import com.hitanshudhawan.popcorn2.database.cache.*
import com.hitanshudhawan.popcorn2.network.models.GenreJson
import com.hitanshudhawan.popcorn2.network.models.MovieBriefJson


/**
 * Movies
 */

@JvmName("mapMovieBriefJsonsToMovieBriefs")
fun List<MovieBriefJson>.mapToMovieBriefs(): List<MovieBrief> {
    return this.map { MovieBrief(it.id, it.title, it.poster_path, it.backdrop_path, it.vote_average, it.genre_ids) }
}

@JvmName("mapMovieBriefsToNowPlayingMovieBriefEntities")
fun List<MovieBrief>.mapToNowPlayingMovieBriefEntities(): List<CacheNowPlayingMovieBriefEntity> {
    return this.map { CacheNowPlayingMovieBriefEntity(0, it.id, it.title, it.poster, it.backdrop, it.rating, it.genreIds) }
}

@JvmName("mapMovieBriefsToPopularMovieBriefEntities")
fun List<MovieBrief>.mapToPopularMovieBriefEntities(): List<CachePopularMovieBriefEntity> {
    return this.map { CachePopularMovieBriefEntity(0, it.id, it.title, it.poster, it.backdrop, it.rating, it.genreIds) }
}

@JvmName("mapMovieBriefsToUpcomingMovieBriefEntities")
fun List<MovieBrief>.mapToUpcomingMovieBriefEntities(): List<CacheUpcomingMovieBriefEntity> {
    return this.map { CacheUpcomingMovieBriefEntity(0, it.id, it.title, it.poster, it.backdrop, it.rating, it.genreIds) }
}

@JvmName("mapMovieBriefsToTopRatedMovieBriefEntities")
fun List<MovieBrief>.mapToTopRatedMovieBriefEntities(): List<CacheTopRatedMovieBriefEntity> {
    return this.map { CacheTopRatedMovieBriefEntity(0, it.id, it.title, it.poster, it.backdrop, it.rating, it.genreIds) }
}

@JvmName("mapNowPlayingMovieBriefEntitiesToMovieBriefs")
fun List<CacheNowPlayingMovieBriefEntity>.mapToMovieBriefs(): List<MovieBrief> {
    return this.map { MovieBrief(it.id, it.title, it.poster, it.backdrop, it.rating, it.genreIds) }
}

@JvmName("mapPopularMovieBriefEntitiesToMovieBriefs")
fun List<CachePopularMovieBriefEntity>.mapToMovieBriefs(): List<MovieBrief> {
    return this.map { MovieBrief(it.id, it.title, it.poster, it.backdrop, it.rating, it.genreIds) }
}

@JvmName("mapUpcomingMovieBriefEntitiesToMovieBriefs")
fun List<CacheUpcomingMovieBriefEntity>.mapToMovieBriefs(): List<MovieBrief> {
    return this.map { MovieBrief(it.id, it.title, it.poster, it.backdrop, it.rating, it.genreIds) }
}

@JvmName("mapTopRatedMovieBriefEntitiesToMovieBriefs")
fun List<CacheTopRatedMovieBriefEntity>.mapToMovieBriefs(): List<MovieBrief> {
    return this.map { MovieBrief(it.id, it.title, it.poster, it.backdrop, it.rating, it.genreIds) }
}


/**
 * Genres
 */

@JvmName("mapGenreJsonsToGenres")
fun List<GenreJson>.mapToGenres(): List<Genre> {
    return this.map { Genre(it.id, it.name) }
}

@JvmName("mapGenresToMovieGenreEntities")
fun List<Genre>.mapToMovieGenreEntities(): List<CacheMovieGenreEntity> {
    return this.map { CacheMovieGenreEntity(0, it.id, it.name) }
}

@JvmName("mapGenresToTVShowGenreEntities")
fun List<Genre>.mapToTVShowGenreEntities(): List<CacheTVShowGenreEntity> {
    return this.map { CacheTVShowGenreEntity(0, it.id, it.name) }
}

@JvmName("mapMovieGenreEntitiesToGenres")
fun List<CacheMovieGenreEntity>.mapToGenres(): List<Genre> {
    return this.map { Genre(it.id, it.name) }
}

@JvmName("mapTVShowGenreEntitiesToGenres")
fun List<CacheTVShowGenreEntity>.mapToGenres(): List<Genre> {
    return this.map { Genre(it.id, it.name) }
}
