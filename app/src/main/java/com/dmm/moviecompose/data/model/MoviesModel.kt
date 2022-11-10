package com.dmm.moviecompose.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json

@Entity(tableName = "movies")
data class MoviesModel(
	@PrimaryKey(autoGenerate = true)
	val id: Int,
	@field:Json(name = "page")
	val page: Int?,
	@field:Json(name = "results")
	val movies: List<Movie>,
	@field:Json(name = "total_pages")
	val totalPages: Int?,
	@field:Json(name = "total_results")
	val totalResults: Int?
)
