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
fun List<MovieBrief>.mapToNowPlayingMovieBriefEntities(): List<NowPlayingMovieBriefEntity> {
    return this.mapIndexed { index, it -> NowPlayingMovieBriefEntity(index, it.id, it.title, it.poster, it.backdrop, it.rating, it.genreIds) }
}

@JvmName("mapMovieBriefsToPopularMovieBriefEntities")
fun List<MovieBrief>.mapToPopularMovieBriefEntities(): List<PopularMovieBriefEntity> {
    return this.mapIndexed { index, it -> PopularMovieBriefEntity(index, it.id, it.title, it.poster, it.backdrop, it.rating, it.genreIds) }
}

@JvmName("mapMovieBriefsToUpcomingMovieBriefEntities")
fun List<MovieBrief>.mapToUpcomingMovieBriefEntities(): List<UpcomingMovieBriefEntity> {
    return this.mapIndexed { index, it -> UpcomingMovieBriefEntity(index, it.id, it.title, it.poster, it.backdrop, it.rating, it.genreIds) }
}

@JvmName("mapMovieBriefsToTopRatedMovieBriefEntities")
fun List<MovieBrief>.mapToTopRatedMovieBriefEntities(): List<TopRatedMovieBriefEntity> {
    return this.mapIndexed { index, it -> TopRatedMovieBriefEntity(index, it.id, it.title, it.poster, it.backdrop, it.rating, it.genreIds) }
}

@JvmName("mapNowPlayingMovieBriefEntitiesToMovieBriefs")
fun List<NowPlayingMovieBriefEntity>.mapToMovieBriefs(): List<MovieBrief> {
    return this.map { MovieBrief(it.id, it.title, it.poster, it.backdrop, it.rating, it.genreIds) }
}

@JvmName("mapPopularMovieBriefEntitiesToMovieBriefs")
fun List<PopularMovieBriefEntity>.mapToMovieBriefs(): List<MovieBrief> {
    return this.map { MovieBrief(it.id, it.title, it.poster, it.backdrop, it.rating, it.genreIds) }
}

@JvmName("mapUpcomingMovieBriefEntitiesToMovieBriefs")
fun List<UpcomingMovieBriefEntity>.mapToMovieBriefs(): List<MovieBrief> {
    return this.map { MovieBrief(it.id, it.title, it.poster, it.backdrop, it.rating, it.genreIds) }
}

@JvmName("mapTopRatedMovieBriefEntitiesToMovieBriefs")
fun List<TopRatedMovieBriefEntity>.mapToMovieBriefs(): List<MovieBrief> {
    return this.map { MovieBrief(it.id, it.title, it.poster, it.backdrop, it.rating, it.genreIds) }
}


/**
 * Genres
 */

@JvmName("mapGenreJsonsToGenres")
fun List<GenreJson>.mapToGenres(): List<Genre> {
    return this.map { Genre(it.id, it.name) }
}

@JvmName("mapGenreJsonsToMovieGenreEntities")
fun List<GenreJson>.mapToMovieGenreEntities(): List<MovieGenreEntity> {
    return this.mapIndexed { index, it -> MovieGenreEntity(index, it.id, it.name) }
}

@JvmName("mapGenreJsonsToTVShowGenreEntities")
fun List<GenreJson>.mapToTVShowGenreEntities(): List<TVShowGenreEntity> {
    return this.mapIndexed { index, it -> TVShowGenreEntity(index, it.id, it.name) }
}

@JvmName("mapMovieGenreEntitiesToGenres")
fun List<MovieGenreEntity>.mapToGenres(): List<Genre> {
    return this.map { Genre(it.id, it.name) }
}

@JvmName("mapTVShowGenreEntitiesToGenres")
fun List<TVShowGenreEntity>.mapToGenres(): List<Genre> {
    return this.map { Genre(it.id, it.name) }
}

// hitanshu : this.mapIndexed where index in added as orderIndex will break when we use the api as paginated.
