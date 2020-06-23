package com.hitanshudhawan.popcorn2

import com.hitanshudhawan.popcorn2.network.models.GenresJson
import com.hitanshudhawan.popcorn2.network.models.MoviesJson


/**
 * Movies
 */

@JvmName("mapMoviesJsonToMovieBriefs")
fun MoviesJson.mapToMovieBriefs(): List<MovieBrief> {
    return this.results.mapIndexed { index, it -> MovieBrief(page, index, it.id, it.title, it.poster_path, it.backdrop_path, it.vote_average, it.genre_ids) }
}

/**
 * Genres
 */

@JvmName("mapGenresJsonToGenres")
fun GenresJson.mapToGenres(): List<Genre> {
    return this.genres.map { Genre(it.id, it.name) }
}
