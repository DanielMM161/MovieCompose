package com.dmm.moviecompose.domain.repository

import com.dmm.moviecompose.data.model.Genre
import com.dmm.moviecompose.data.model.GenresModel
import com.dmm.moviecompose.data.model.AudiovisualModel
import com.dmm.moviecompose.data.model.MoviesModel
import com.dmm.moviecompose.data.model.detail.MovieDetail
import com.dmm.moviecompose.data.model.detail.SerieDetail
import kotlinx.coroutines.flow.Flow


interface SerieRepository {

	suspend fun getPopularSeries(page: Int): List<AudiovisualModel>

	suspend fun getSerieDetail(id: Int): SerieDetail

	suspend fun getSeriesGenre(): List<Genre>
}