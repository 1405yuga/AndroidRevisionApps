package com.example.testing.home_fragment

import android.util.Log
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testing.network.Exercise
import com.example.testing.network.ExerciseApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeViewModel : ViewModel() {
    private val TAG = this.javaClass.simpleName
    var exerciseList: List<Exercise> = emptyList()

    private val _screenState: MutableLiveData<ScreenStates> = MutableLiveData(ScreenStates.LOADED)
    val screenState: LiveData<ScreenStates> = _screenState

    fun loadExercises(forceReload: Boolean) {
        if (forceReload || (exerciseList.isEmpty() && (screenState.value?.isLoading != true))) {
            _screenState.value = ScreenStates.LOADING
            viewModelScope.launch {
                try {
                    exerciseList = ExerciseApi.retrofitServiceApi.getAll().asList()
                    Log.d(TAG, "List in vm : ${exerciseList.size}")
                    ScreenStates.LOADED
                } catch (e: Exception) {
                    e.printStackTrace()
                    ScreenStates.ERROR
                }.let {
                    withContext(Dispatchers.Main) {
                        _screenState.value = it
                    }
                }
            }
        } else {
            Log.d(TAG, "Already initialised")
        }
    }
}

enum class ScreenStates {
    LOADING, LOADED, ERROR;

    val isLoading: Boolean get() = (this == LOADING)

    companion object {
        fun getVisibility(isVisible: Boolean): Int {
            return if (isVisible) View.VISIBLE else View.GONE
        }
    }
}