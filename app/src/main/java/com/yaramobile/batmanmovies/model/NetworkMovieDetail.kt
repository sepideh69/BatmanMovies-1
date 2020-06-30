package com.yaramobile.batmanmovies.model


import com.google.gson.annotations.SerializedName
import com.yaramobile.batmanmovies.database.DatabaseMovieDetail

data class NetworkMovieDetail(
    @SerializedName("Title") val title: String,
    @SerializedName("Year") val year: String,
    @SerializedName("Rated") val rated: String?,
    @SerializedName("Released") val released: String?,
    @SerializedName("Runtime") val runtime: String?,
    @SerializedName("Genre") val genre: String?,
    @SerializedName("Director") val director: String?,
    @SerializedName("Writer") val writer: String?,
    @SerializedName("Actors") val actors: String?,
    @SerializedName("Plot") val plot: String?,
    @SerializedName("Language") val language: String?,
    @SerializedName("Country") val country: String?,
    @SerializedName("Awards") val awards: String?,
    @SerializedName("Poster") val poster: String,

    @SerializedName("Metascore") val metascore: String?,
    @SerializedName("imdbRating") val imdbRating: String?,
    @SerializedName("imdbVotes") val imdbVotes: String?,
    @SerializedName("imdbID") val imdbID: String,
    @SerializedName("Type") val type: String,
    @SerializedName("DVD") val dVD: String?,
    @SerializedName("BoxOffice") val boxOffice: String?,
    @SerializedName("Production") val production: String?,
    @SerializedName("Website") val website: String?,
    @SerializedName("Response") val response: String?
)

fun List<NetworkMovieDetail>.asDatabaseModel(): Array<DatabaseMovieDetail> {
    return map {
        DatabaseMovieDetail(
            title = it.title,
            year = it.year,
            rated = it.rated,
            released = it.released,
            runtime = it.runtime,
            genre = it.genre,
            director = it.director,
            writer = it.writer,
            actors = it.actors,
            plot = it.plot,
            language = it.language,
            country = it.country,
            awards = it.awards,
            poster = it.poster,

            metascore = it.metascore,
            imdbRating = it.imdbRating,
            imdbVotes = it.imdbVotes,
            imdbID = it.imdbID,
            type = it.type,
            dVD = it.dVD,
            boxOffice = it.boxOffice,
            production = it.production,
            website = it.website,
            response = it.response
        )

    }.toTypedArray()
}
fun NetworkMovieDetail.asDatabaseModelDetail()=

    DatabaseMovieDetail(
        title = title,
        year = year,
        rated = rated,
        released = released,
        runtime = runtime,
        genre = genre,
        director = director,
        writer = writer,
        actors = actors,
        plot = plot,
        language = language,
        country = country,
        awards = awards,
        poster = poster,

        metascore = metascore,
        imdbRating = imdbRating,
        imdbVotes = imdbVotes,
        imdbID = imdbID,
        type = type,
        dVD = dVD,
        boxOffice = boxOffice,
        production = production,
        website = website,
        response = response
    )

