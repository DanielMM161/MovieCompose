package com.dmm.moviecompose.data.model

import com.squareup.moshi.Json

data class MovieGenresModel(
	@field:Json(name = "genres")
	val genres: List<MovieGenre>
)
