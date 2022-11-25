package com.dmm.moviecompose.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MoviesModel(
	@field:Json(name = "page")
	val page: Int = 0,
	@field:Json(name = "results")
	val movies: List<Movie> = listOf(),
	@field:Json(name = "total_pages")
	val totalPages: Int = 0,
	@field:Json(name = "total_results")
	val totalResults: Int = 0
)
