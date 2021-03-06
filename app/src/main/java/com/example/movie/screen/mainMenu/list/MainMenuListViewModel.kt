package com.example.movie.screen.mainMenu.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movie.network.MovieApi
import com.example.movie.network.MovieGenre
import com.example.movie.network.MovieProperties
import kotlinx.coroutines.launch

//enum class MovieApiStatus { LOADING, ERROR, DONE }

class MainMenuListViewModel : ViewModel() {

    private val _movie = MutableLiveData<List<MovieProperties>>()
    val movie: LiveData<List<MovieProperties>>
        get() = _movie

    private val _genre=MutableLiveData<List<MovieGenre>>()
    val genre: LiveData<List<MovieGenre>>
        get() = _genre

    init {
        getCinemaProperties()
    }

    private fun getCinemaProperties() {
        viewModelScope.launch {
            val listResult = MovieApi.retrofitService.getProperties().results
            _movie.postValue(listResult)
                  }
    }

    private fun getMovieGenre(){
        viewModelScope.launch { val genreList=MovieApi.retrofitService.getMovieGenre()
        _genre.postValue(listOf(genreList))}
    }
}

