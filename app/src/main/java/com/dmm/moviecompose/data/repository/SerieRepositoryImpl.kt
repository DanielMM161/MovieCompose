package com.dmm.moviecompose.data.repository

import com.dmm.moviecompose.data.local.GenreDao
import com.dmm.moviecompose.data.local.SerieDao
import com.dmm.moviecompose.data.model.*
import com.dmm.moviecompose.data.model.detail.SerieDetail
import com.dmm.moviecompose.data.remote.AudiovisualApi
import com.dmm.moviecompose.domain.repository.SerieRepository
import com.dmm.moviecompose.utils.Constants.SERIE_TYPE

class SerieRepositoryImpl(
	private val audiovisualApi: AudiovisualApi,
	private val serieDao: SerieDao,
	private val genreDao: GenreDao
): SerieRepository {

	override suspend fun getPopularSeries(page: Int): List<AudiovisualModel> {
		var seriesModel = serieDao.getPopularSeries(page)
		if(seriesModel == null) {
			seriesModel = audiovisualApi.getPopularSeries()
			serieDao.insertSeriesModel(seriesModel)
		}
		return seriesModel.series
	}

	override suspend fun getSerieDetail(id: Int): SerieDetail {
		var serieDetail = serieDao.getSerieDetail(id)
		if(serieDetail == null) {
			serieDetail = audiovisualApi.getSerieDetail(id.toString())
			serieDao.insertSerieDetail(serieDetail)
		}
		return serieDetail
	}

	override suspend fun getSeriesGenre(): List<Genre> {
		var genres = genreDao.getSerieGenre()
		if(genres.isEmpty()) {
			genres = audiovisualApi.getGenreTV().genres
			genres.map { genre -> genre.copy(genreType = SERIE_TYPE) }
			genreDao.insertGenres(genres)
		}
		return genres
	}

}