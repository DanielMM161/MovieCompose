package com.dmm.moviecompose.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@Entity(tableName = "movie")
@JsonClass(generateAdapter = true)
data class Movie (
	@PrimaryKey()
	@ColumnInfo(name = "id")
	@field:Json(name = "id")
	val id: Int = 0,
	@ColumnInfo(name = "page")
	var page: Int = 1,
	@ColumnInfo(name = "adult")
	@field:Json(name = "adult")
	val adult: Boolean = false,
	@ColumnInfo(name = "backdrop_path")
	@field:Json(name = "backdrop_path")
	val backdropPath: String? = null,
	@ColumnInfo(name = "genre_ids")
	@field:Json(name = "genre_ids")
	val genreİds: List<Int> = listOf(),
	@ColumnInfo(name = "original_language")
	@field:Json(name = "original_language")
	val originalLanguage: String = "",
	@ColumnInfo(name = "original_title")
	@field:Json(name = "original_title")
	val originalTitle: String = "",
	@ColumnInfo(name = "overview")
	@field:Json(name = "overview")
	val overview: String = "",
	@ColumnInfo(name = "popularity")
	@field:Json(name = "popularity")
	val popularity: Double = 0.0,
	@ColumnInfo(name = "poster_path")
	@field:Json(name = "poster_path")
	val posterPath: String? = null,
	@ColumnInfo(name = "release_date")
	@field:Json(name = "release_date")
	val releaseDate: String = "",
	@ColumnInfo(name = "title")
	@field:Json(name = "title")
	val title: String = "",
	@ColumnInfo(name = "video")
	@field:Json(name = "video")
	val video: Boolean = false,
	@ColumnInfo(name = "vote_average")
	@field:Json(name = "vote_average")
	val voteAverage: Double = 0.0,
	@ColumnInfo(name = "vote_count")
	@field:Json(name = "vote_count")
	val voteCount: Int = 0
	)