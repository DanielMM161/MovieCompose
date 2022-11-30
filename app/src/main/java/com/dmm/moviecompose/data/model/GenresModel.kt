package com.dmm.moviecompose.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GenresModel(
	@field:Json(name = "genres")
	val genres: List<Genre>
)
