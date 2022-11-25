package com.dmm.moviecompose.data.model

import com.squareup.moshi.Json

data class GenresModel(
	@field:Json(name = "genres")
	val genres: List<Genre>
)
