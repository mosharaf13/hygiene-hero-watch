package com.example.measuredatacompose

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.measuredatacompose.presentation.MeasureDataApp
import com.example.measuredatacompose.presentation.MeasureDataViewModel
import com.example.measuredatacompose.presentation.MeasureDataViewModelFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Keep the screen on while this activity is running
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)

        val healthServicesRepository = (application as MainApplication).healthServicesRepository

        setContent {
            val viewModel: MeasureDataViewModel = viewModel(
                factory = MeasureDataViewModelFactory(
                    healthServicesRepository = healthServicesRepository
                )
            )

            LaunchedEffect(Unit) {
                val playerId = withContext(Dispatchers.IO) {
                    healthServicesRepository.fetchPlayerId()
                }
                healthServicesRepository.setPlayerId(playerId)
                viewModel.setPlayerId(playerId)
            }

            MeasureDataApp(healthServicesRepository = healthServicesRepository)
        }
    }

    companion object {
        private const val TAG = "MainActivity"
    }
}