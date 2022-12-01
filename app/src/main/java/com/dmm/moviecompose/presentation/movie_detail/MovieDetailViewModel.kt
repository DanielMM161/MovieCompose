package com.dmm.moviecompose.presentation.movie_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dmm.moviecompose.domain.use_case.movie.MovieUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(
	private val useCase: MovieUseCase,
	savedStateHandle: SavedStateHandle
): ViewModel() {

	private val _state = mutableStateOf(MovieDetailState())
	val state: State<MovieDetailState> = _state

	init {
		savedStateHandle.get<Int>("movieId")?.let { movieId ->
			if(movieId != -1) {
				viewModelScope.launch {
					_state.value = state.value.copy(
						movieDetail = useCase.getMovieDetail(movieId)
					)
				}
			}
		}
	}
}