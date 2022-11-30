package com.dmm.moviecompose.domain.use_case.serie

import com.dmm.moviecompose.data.model.Genre
import com.dmm.moviecompose.domain.repository.SerieRepository
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async

class GetSeriesGenre(
	val repository: SerieRepository
) {

	@OptIn(DelicateCoroutinesApi::class)
	suspend operator fun invoke(): List<Genre> = GlobalScope.async {
		return@async repository.getSeriesGenre()
	}.await()

}