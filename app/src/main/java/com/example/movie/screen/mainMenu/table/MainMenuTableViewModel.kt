package com.example.movie.screen.mainMenu.table

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movie.network.MovieApi
import com.example.movie.network.MovieProperties
import kotlinx.coroutines.launch

class MainMenuTableViewModel : ViewModel() {

    private val _movie = MutableLiveData<List<MovieProperties>>()
    val movie: LiveData<List<MovieProperties>>
        get() = _movie

    init {
        getCinemaProperties()
    }

    private fun getCinemaProperties() {
        viewModelScope.launch {
            val listResult = MovieApi.retrofitService.getProperties().results
            _movie.postValue(listResult)
        }
    }
}