package com.agilefreaks.summer_practice_android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.agilefreaks.summer_practice_android.components.mobile.MobileFreaksApp
import com.agilefreaks.summer_practice_android.components.tv.TvFreaksApp
import com.agilefreaks.summer_practice_android.ui.theme.SummerPracticeAndroidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            SummerPracticeAndroidTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TvFreaksApp()
                }
            }
        }
    }
}