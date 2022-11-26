package com.dmm.moviecompose.di

import android.app.Application
import androidx.room.Room
import com.dmm.moviecompose.data.local.MovieDao
import com.dmm.moviecompose.data.local.MovieDataBase
import com.dmm.moviecompose.data.local.MovieGenreDao
import com.dmm.moviecompose.data.local.converters.ConverterGenreDto
import com.dmm.moviecompose.data.local.converters.ConverterMovieDetailCastList
import com.dmm.moviecompose.data.local.converters.ConverterMovieDetailGenreList
import com.dmm.moviecompose.data.local.converters.ConverterMovieGenreList
import com.dmm.moviecompose.data.remote.MovieApi
import com.dmm.moviecompose.data.repository.MovieRepositoryImpl
import com.dmm.moviecompose.domain.repository.MovieRepository
import com.dmm.moviecompose.domain.use_case.GetGenreMovies
import com.dmm.moviecompose.domain.use_case.GetMovieDetail
import com.dmm.moviecompose.domain.use_case.GetMovies
import com.dmm.moviecompose.domain.use_case.MovieUseCase
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
		converterMovieGenreList: ConverterMovieGenreList,
		converterMovieDetailGenreList: ConverterMovieDetailGenreList,
		converterMovieDetailCastList: ConverterMovieDetailCastList
	): MovieDataBase {
		return Room
			.databaseBuilder(
				app,
				MovieDataBase::class.java,
				MovieDataBase.DATABASE_NAME
			)
			.fallbackToDestructiveMigration()
			.addTypeConverter(converterMovieGenreList)
			.addTypeConverter(converterMovieDetailGenreList)
			.addTypeConverter(converterMovieDetailCastList)
			.build()
	}

	@Provides
	@Singleton
	fun provideMovieDao(movieDataBase: MovieDataBase): MovieDao {
		return movieDataBase.movieDao
	}

	@Provides
	@Singleton
	fun provideGenreDao(movieDataBase: MovieDataBase): MovieGenreDao {
		return movieDataBase.movieGenreDao
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
	fun provideUseCase(repository: MovieRepository): MovieUseCase {
		return MovieUseCase(
			getMovies = GetMovies(repository),
			getGenreMovies = GetGenreMovies(repository),
			getMovieDetail = GetMovieDetail(repository)
		)
	}

	@Provides
	@Singleton
	fun provideMovieApi(retrofit: Retrofit) : MovieApi {
		return retrofit.create(MovieApi::class.java)
	}

	@Provides
	@Singleton
	fun provideRepository(movieApi: MovieApi, movieDao: MovieDao, movieGenreDao: MovieGenreDao): MovieRepository {
		return MovieRepositoryImpl(movieApi, movieDao, movieGenreDao)
	}

	@Provides
	@Singleton
	fun provideConverteGenreDto(moshi: Moshi): ConverterGenreDto {
		return ConverterGenreDto(moshi)
	}

	@Provides
	@Singleton
	fun provideConverterMovieGenreList(moshi: Moshi): ConverterMovieGenreList {
		return ConverterMovieGenreList(moshi)
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

}