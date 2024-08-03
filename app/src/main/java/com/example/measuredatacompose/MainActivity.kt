package com.example.measuredatacompose

import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.measuredatacompose.presentation.MeasureDataApp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Keep the screen on while this activity is running
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)

        val healthServicesRepository = (application as MainApplication).healthServicesRepository

        CoroutineScope(Dispatchers.IO).launch {
            val playerId = healthServicesRepository.fetchPlayerId()
            healthServicesRepository.setPlayerId(playerId)
        }

        setContent {
            MeasureDataApp(healthServicesRepository = healthServicesRepository)
        }
    }

    companion object {
        private const val TAG = "MainActivity"
    }
}
