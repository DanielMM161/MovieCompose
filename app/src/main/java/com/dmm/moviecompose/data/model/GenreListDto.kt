package com.dmm.moviecompose.data.model

import com.squareup.moshi.Json

data class GenreListDto(
	@field:Json(name = "genres")
	val genres: List<GenreDto>
)
