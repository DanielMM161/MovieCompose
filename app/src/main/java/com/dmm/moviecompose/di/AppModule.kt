package com.dmm.moviecompose.di

import android.app.Application
import androidx.room.Room
import com.dmm.moviecompose.data.local.MovieDataBase
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
	fun provideDataBase(app: Application): MovieDataBase {
		return Room.databaseBuilder(
			app,
			MovieDataBase::class.java,
			MovieDataBase.DATABASE_NAME
		).build()
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
	fun provideRetrofitInstance(okHttpClient: OkHttpClient): Retrofit {
		return Retrofit.Builder()
			.baseUrl(BASE_URL)
			.client(okHttpClient)
			.addConverterFactory(MoshiConverterFactory.create())
			.build()
	}

}