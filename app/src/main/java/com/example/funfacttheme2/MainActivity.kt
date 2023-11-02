package com.example.funfacttheme2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.funfacttheme2.ui.theme.FunFactTheme2Theme
import com.example.funfacttheme2.ui.theme.screen.FunFactsNavigationGraph

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        installSplashScreen()
        setContent {
            FunFactTheme2Theme {
                FunFactsApp()
        }
    }
}

    private fun installSplashScreen() {

    }


}

@Composable
fun FunFactsApp() {
    FunFactsNavigationGraph()
}