package com.example.testing

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.lifecycleScope
import com.example.testing.databinding.ActivityMainBinding
import com.example.testing.home_fragment.HomeViewModel
import com.example.testing.home_fragment.ScreenStates
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private val viewModel: HomeViewModel by viewModels()
    private val TAG = this.javaClass.simpleName
    private lateinit var binding: ActivityMainBinding

    private val testIsLoading: MutableLiveData<Boolean> = MutableLiveData(false)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        applyBindings()
        viewModel.loadExercises(forceReload = false)
        Log.d(TAG, "List : ${viewModel.exerciseList}")
    }

    private fun applyBindings() {
        binding.retryButton.setOnClickListener { viewModel.loadExercises(forceReload = false) }
        binding.tryAgainButton.setOnClickListener { viewModel.loadExercises(forceReload = true) }
        viewModel.screenState.observe(this) {
            binding.mainTextView.visibility =
                ScreenStates.getVisibility(isVisible = (it == ScreenStates.LOADED))
            binding.mainTextView.text = viewModel.exerciseList.size.toString()
            binding.progressIndicator.visibility =
                ScreenStates.getVisibility(isVisible = (it == ScreenStates.LOADING))
            binding.retryButton.visibility =
                ScreenStates.getVisibility(isVisible = (it == ScreenStates.ERROR))

        }
        lifecycleScope.launch {
            testIsLoading.value = true
            delay(3000)
            testIsLoading.value = false
        }.invokeOnCompletion {
            Log.d(TAG, "invokeOnCompletion called")
        }

        testIsLoading.observe(this) {
            binding.testProgressIndicator.visibility = ScreenStates.getVisibility(isVisible = it)
        }
    }

}