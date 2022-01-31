package com.example.movie.screen.mainMenu.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movie.network.MovieApi
import com.example.movie.network.MovieProperties
import kotlinx.coroutines.launch

//enum class MovieApiStatus { LOADING, ERROR, DONE }

class MainMenuListViewModel : ViewModel() {

    private val _property = MutableLiveData<MovieProperties>()
    val property: LiveData<MovieProperties>
        get() = _property

    // The internal MutableLiveData String that stores the most recent response
    private val _response = MutableLiveData<String>()
    // The external immutable LiveData for the response String
    val response: LiveData<String>
        get() = _response


    /**
     * Call getCinemaProperties() on init so we can display status immediately.
     */
    init {
        getCinemaProperties()
    }

    private fun getCinemaProperties() {
        viewModelScope.launch {
            try {
                val listResult = MovieApi.retrofitService.getProperties()
                _response.value = "Success: ${listResult.size} Movie properties retrieved"
                if (listResult.size > 0) {
                    _property.value = listResult[0]
                }
            } catch (e: Exception) {
                _response.value = "Failure: ${e.message}"

            }
        }
    }
}

