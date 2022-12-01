package com.dmm.moviecompose.domain.util

sealed class MovieOrder() {
	class Popular() : MovieOrder()
	class Genre(open val genreIds: List<Int>) : MovieOrder()
}
