package com.dmm.moviecompose.presentation.movies

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dmm.moviecompose.data.model.Genre
import com.dmm.moviecompose.domain.use_case.movie.MovieUseCase
import com.dmm.moviecompose.domain.use_case.serie.SerieUseCase
import com.dmm.moviecompose.domain.util.MovieOrder
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(
		val useCase: MovieUseCase,
		val serieUseCase: SerieUseCase
) : ViewModel() {

	private val _state = mutableStateOf(MovieState())
	val state: State<MovieState> = _state

	private val _eventFlow = MutableSharedFlow<UiEvent>()
	val eventFlow = _eventFlow.asSharedFlow()

	private var getMovieJob: Job? = null

	init {
		viewModelScope.launch {
			callLoading() {
				useCase.getGenreMovies().let {
					_state.value = state.value.copy(
						genres = it
					)
				}
				getMovies(MovieOrder.Popular())
			}
		}

	}

	fun onEvent(event: MovieEvent) {
		when(event) {
			is MovieEvent.Order -> {
				viewModelScope.launch {
					callLoading() {
						getMovies(event.movieOrder)
					}
				}
			}
			is MovieEvent.SelectGenre -> {
				_state.value = state.value.copy(
					genres = state.value.genres.map {
						if(it.genre_id == event.genreId) {
							Genre(
								genre_id = it.genre_id,
								name = it.name,
								genreType = it.genreType,
								isSelected = !it.isSelected
							)
						} else {
							it
						}
					}
				)
			}
		}
	}

	suspend fun getMovies(movieOrder: MovieOrder) {
			useCase.getMovies(movieOrder)
			.let { movieList ->
				_state.value = state.value.copy(
					movies = movieList,
					movieOrder = movieOrder
				)
			}
	}

	private suspend fun callLoading(callback: suspend () -> Unit) {
		_eventFlow.emit(
			UiEvent.Loading(isLoading = true)
		)
		delay(500)
		callback()
		_eventFlow.emit(
			UiEvent.Loading(isLoading = false)
		)
	}

	sealed class UiEvent() {
		data class Loading(val isLoading: Boolean) : UiEvent()
	}

}