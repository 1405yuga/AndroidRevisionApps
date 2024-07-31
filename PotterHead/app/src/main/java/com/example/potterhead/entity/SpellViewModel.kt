package com.example.potterhead.entity

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.potterhead.service.PotterApiService
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SpellViewModel : ViewModel() {

    private val TAG = this.javaClass.simpleName
    private val _spellsList = MutableLiveData<List<Spell>>()
    val spellsList: LiveData<List<Spell>> = _spellsList
    private val _isDataLoading = MutableLiveData<Boolean>(true)
    val isDataLoading: LiveData<Boolean> = _isDataLoading
    private val _errorText = MutableLiveData<String?>(null)
    val errorText: LiveData<String?> = _errorText

    fun getSpellsList() {
        _isDataLoading.value = true
        viewModelScope.launch {
            try {
                val spells = PotterApiService.retrofitApiService.getAllSpells()
                Log.d(TAG, "List received : ${spells.size}")
                _spellsList.value = spells
                _errorText.value = if (spells.isEmpty()) "No data" else null
            } catch (e: Exception) {
                _errorText.value = "Unable to load spells"
                e.printStackTrace()
            } finally {
                _isDataLoading.value = false
            }
        }
    }

    val testState: TestState = TestState(
        isRunning = false,
        testLambda = null
    )

    fun runTest() {
        if (testState.isRunning) {
            Log.d(TAG, "Already running")
        } else {
            this.testState.isRunning = true
            viewModelScope.launch {
                repeat(
                    times = 10,
                    action = {
                        delay(1_000L)
                        Log.d(TAG, "c = $it")
                    }
                )
                this@SpellViewModel.testState.testLambda!!.invoke()
                this@SpellViewModel.testState.isRunning = false
            }
        }
    }
}

data class TestState(
    var isRunning: Boolean,
    var testLambda: (() -> Unit)?
) {
    fun setState(lambda: () -> Unit) {
        this.testLambda = lambda
    }
}