package com.dmm.moviecompose.data.model.detail

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.dmm.moviecompose.data.model.Cast
import com.dmm.moviecompose.data.model.Genre
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@Entity( tableName = "movie_detail")
@JsonClass(generateAdapter = true)
data class MovieDetail(
	@PrimaryKey
	@ColumnInfo(name = "id")
	@field:Json(name = "id")
	val id: Int = 0,
	@ColumnInfo(name = "backdrop_path")
	@field:Json(name = "backdrop_path")
	val backdropPath: String = "",
	@ColumnInfo(name = "genres")
	@field:Json(name = "genres")
	val genres: List<Genre> = listOf(),
	@ColumnInfo(name = "original_title")
	@field:Json(name = "original_title")
	val originalTitle: String = "",
	@ColumnInfo(name = "title")
	@field:Json(name = "title")
	val title: String = "",
	@ColumnInfo(name = "release_date")
	@field:Json(name = "release_date")
	val releaseDate: String = "",
	@ColumnInfo(name = "vote_average")
	@field:Json(name = "vote_average")
	val voteAverage: Double = 0.0,
	@ColumnInfo(name = "tagline")
	@field:Json(name = "tagline")
	val tagLine: String = "",
	@ColumnInfo(name = "overview")
	@field:Json(name = "overview")
	val overView: String = "",
	@ColumnInfo(name = "cast")
	val cast: List<Cast> = listOf()
)


