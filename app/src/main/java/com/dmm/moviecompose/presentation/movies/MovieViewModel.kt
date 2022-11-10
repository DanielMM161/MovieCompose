package com.dmm.moviecompose.presentation.movies

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dmm.moviecompose.domain.use_case.MovieUseCase
import com.dmm.moviecompose.domain.util.MovieOrder
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
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

	private var getMovieJob: Job? = null

	init {
		viewModelScope.launch {
			useCase.getGenreMovies().let {
				_state.value = state.value.copy(
					movieGenre = it
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
		}
	}

	fun getMovies(movieOrder: MovieOrder) {
		getMovieJob?.cancel()
		getMovieJob = useCase.getMovies(movieOrder)
			.onEach { movieList ->
				_state.value = state.value.copy(
					movies = movieList
				)
			}.launchIn(viewModelScope)
	}


}