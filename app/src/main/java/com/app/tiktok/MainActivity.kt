package com.app.tiktok

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import com.app.tiktok.ui.NavGraph


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //WindowCompat.setDecorFitsSystemWindows(window, false) //  Avoids overlaps on Android 10+
        window.statusBarColor = Color.Black.toArgb() // Set your desired color

        setContent {
            NavGraph()
        }
    }
}
