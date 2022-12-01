package com.dmm.moviecompose.domain.util

sealed class OrderType() {
	class Genre(genreIds: List<Int>? = null): OrderType()
}
