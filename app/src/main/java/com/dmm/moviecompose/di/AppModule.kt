package com.dmm.moviecompose.di

import android.app.Application
import androidx.room.Room
import com.dmm.moviecompose.data.local.MovieDao
import com.dmm.moviecompose.data.local.AudiovisualDataBase
import com.dmm.moviecompose.data.local.GenreDao
import com.dmm.moviecompose.data.local.SerieDao
import com.dmm.moviecompose.data.local.converters.*
import com.dmm.moviecompose.data.remote.AudiovisualApi
import com.dmm.moviecompose.data.repository.MovieRepositoryImpl
import com.dmm.moviecompose.data.repository.SerieRepositoryImpl
import com.dmm.moviecompose.domain.repository.MovieRepository
import com.dmm.moviecompose.domain.repository.SerieRepository
import com.dmm.moviecompose.domain.use_case.movie.GetGenreMovies
import com.dmm.moviecompose.domain.use_case.movie.GetMovieDetail
import com.dmm.moviecompose.domain.use_case.movie.GetMovies
import com.dmm.moviecompose.domain.use_case.movie.MovieUseCase
import com.dmm.moviecompose.domain.use_case.serie.GetSeries
import com.dmm.moviecompose.domain.use_case.serie.GetSeriesGenre
import com.dmm.moviecompose.domain.use_case.serie.SerieUseCase
import com.dmm.moviecompose.utils.Constants.BASE_URL
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

	@Provides
	@Singleton
	fun provideDataBase(
		app: Application,
		converterMovieDetailGenreList: ConverterMovieDetailGenreList,
		converterMovieDetailCastList: ConverterMovieDetailCastList,
		converterAudiovisualModelList: ConverterAudiovisualModelList,
	): AudiovisualDataBase {
		return Room
			.databaseBuilder(
				app,
				AudiovisualDataBase::class.java,
				AudiovisualDataBase.DATABASE_NAME
			)
			.fallbackToDestructiveMigration()
			.addTypeConverter(converterMovieDetailGenreList)
			.addTypeConverter(converterMovieDetailCastList)
			.addTypeConverter(converterAudiovisualModelList)
			.build()
	}

	@Provides
	@Singleton
	fun provideMovieDao(audiovisualDataBase: AudiovisualDataBase): MovieDao {
		return audiovisualDataBase.movieDao
	}

	@Provides
	@Singleton
	fun provideGenreDao(audiovisualDataBase: AudiovisualDataBase): GenreDao {
		return audiovisualDataBase.genreDao
	}

	@Provides
	@Singleton
	fun provideSerieDao(audiovisualDataBase: AudiovisualDataBase): SerieDao {
		return audiovisualDataBase.serieDao
	}

	@Provides
	@Singleton
	fun provideMoshi(): Moshi {
		return Moshi.Builder()
			.addLast(KotlinJsonAdapterFactory())
			.build()
	}

	@Provides
	@Singleton
	fun provideOkHttpClient(): OkHttpClient {
		return OkHttpClient().newBuilder()
			.retryOnConnectionFailure(true)
			.followRedirects(true)
			.followSslRedirects(true)
			.connectTimeout(200, TimeUnit.SECONDS)
			.readTimeout(200, TimeUnit.SECONDS)
			.build()
	}

	@Provides
	@Singleton
	fun provideRetrofitInstance(okHttpClient: OkHttpClient, moshi: Moshi): Retrofit {
		return Retrofit.Builder()
			.baseUrl(BASE_URL)
			.client(okHttpClient)
			.addConverterFactory(MoshiConverterFactory.create(moshi))
			.build()
	}

	@Provides
	@Singleton
	fun provideMovieUseCase(repository: MovieRepository): MovieUseCase {
		return MovieUseCase(
			getMovies = GetMovies(repository),
			getGenreMovies = GetGenreMovies(repository),
			getMovieDetail = GetMovieDetail(repository)
		)
	}

	@Provides
	@Singleton
	fun provideSerieUseCase(repository: SerieRepository): SerieUseCase {
		return SerieUseCase(
			getSeries = GetSeries(repository),
			seriesGenre = GetSeriesGenre(repository)
		)
	}

	@Provides
	@Singleton
	fun provideAudiovisualApi(retrofit: Retrofit): AudiovisualApi {
		return retrofit.create(AudiovisualApi::class.java)
	}

	@Provides
	@Singleton
	fun provideMovieRepository(
		audiovisualApi: AudiovisualApi,
		movieDao: MovieDao,
		genreDao: GenreDao
	): MovieRepository {
		return MovieRepositoryImpl(audiovisualApi, movieDao, genreDao)
	}

	@Provides
	@Singleton
	fun provideSerieRepository(
		audiovisualApi: AudiovisualApi,
		serieDao: SerieDao,
		genreDao: GenreDao
	): SerieRepository {
		return SerieRepositoryImpl(audiovisualApi, serieDao, genreDao)
	}

	@Provides
	@Singleton
	fun provideConverteGenreDto(moshi: Moshi): ConverterGenreDto {
		return ConverterGenreDto(moshi)
	}

	@Provides
	@Singleton
	fun provideConverterMovieDetailGenreList(moshi: Moshi): ConverterMovieDetailGenreList {
		return ConverterMovieDetailGenreList(moshi)
	}

	@Provides
	@Singleton
	fun provideConverterMovideDetailCastList(moshi: Moshi): ConverterMovieDetailCastList {
		return ConverterMovieDetailCastList(moshi)
	}

	@Provides
	@Singleton
	fun provideConverterAudiovisualModelList(moshi: Moshi): ConverterAudiovisualModelList {
		return ConverterAudiovisualModelList(moshi)
	}

}