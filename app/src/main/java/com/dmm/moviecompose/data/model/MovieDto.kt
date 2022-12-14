package com.dmm.moviecompose.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json

@Entity( tableName = "Movie")
data class MovieDto(
	@PrimaryKey
	@ColumnInfo(name = "id")
	@field:Json(name = "id")
	val id: Int?,
	@ColumnInfo(name = "backdrop_path")
	@field:Json(name = "backdrop_path")
	val backdropPath: String? = null,
	@ColumnInfo(name = "genres")
	@field:Json(name = "genres")
	val genres: List<GenreDto>?,
	@ColumnInfo(name = "original_title")
	@field:Json(name = "original_title")
	val originalTitle: String?,
	@ColumnInfo(name = "popularity")
	@field:Json(name = "popularity")
	val popularity: Double?,
	@ColumnInfo(name = "tagline")
	@field:Json(name = "tagline")
	val tagLine: String?,
	@ColumnInfo(name = "overview")
	@field:Json(name = "overview")
	val overView: String?,
	@ColumnInfo(name = "page")
	val page: Int?
)
