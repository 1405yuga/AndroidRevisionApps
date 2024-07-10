package com.example.calculator.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CalculatorViewModel : ViewModel() {
    private val _input: MutableLiveData<String> = MutableLiveData(null)
    private val _output: MutableLiveData<Double?> = MutableLiveData()
    private val _highlightOutput: MutableLiveData<Boolean> = MutableLiveData(false)
    val input: LiveData<String> get() = _input
    val output: LiveData<Double?> get() = _output
    val highlightOutput: LiveData<Boolean> get() = _highlightOutput

    private var currentValue: String = ""
    fun setInput(inputText: String) {
        if (inputText == "+" || inputText == "-" || inputText == "x" || inputText == "÷") {
            if (currentValue.isNotEmpty() && currentValue[currentValue.length - 1].isDigit()) {
                currentValue += inputText
                _input.value = currentValue
                _highlightOutput.value = false
            }
        } else {
            currentValue += inputText
            _input.value = currentValue
            _highlightOutput.value = false
        }
    }

    fun clearInput() {
        _input.value = ""
        currentValue = ""
    }

    fun equalsClicked(){
        _highlightOutput.value = true
    }
}