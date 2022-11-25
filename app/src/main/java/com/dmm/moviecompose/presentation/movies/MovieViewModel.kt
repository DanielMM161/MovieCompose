package com.dmm.moviecompose.presentation.movies

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dmm.moviecompose.data.model.Genre
import com.dmm.moviecompose.domain.use_case.MovieUseCase
import com.dmm.moviecompose.domain.util.MovieOrder
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(
		val useCase: MovieUseCase
) : ViewModel() {

	private val _state = mutableStateOf(MovieState())
	val state: State<MovieState> = _state

	private val _eventFlow = MutableSharedFlow<UiEvent>()
	val eventFlow = _eventFlow.asSharedFlow()

	private var getMovieJob: Job? = null

	init {
		viewModelScope.launch {
			useCase.getGenreMovies().let {
				_state.value = state.value.copy(
					genres = it
				)
			}
		}
		getMovies(MovieOrder.Popular())
	}

	fun onEvent(event: MovieEvent) {
		when(event) {
			is MovieEvent.Order -> {
				getMovies(event.movieOrder)
			}
			is MovieEvent.SelectGenre -> {
				_state.value = state.value.copy(
					genres = state.value.genres.map {
						if(it.genre_id == event.genreId) {
							Genre(genre_id = it.genre_id, name = it.name, isSelected = !it.isSelected)
						} else {
							it
						}
					}
				)
			}
		}
	}

	fun getMovies(movieOrder: MovieOrder) = viewModelScope.launch {
			useCase.getMovies(movieOrder)
			.let { movieList ->
				_state.value = state.value.copy(
					movies = movieList,
					movieOrder = movieOrder
				)
			}
	}

	sealed class UiEvent() {
		class selectGenre() : UiEvent()
	}

}