package com.example.funfacttheme2.ui.theme.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.funfacttheme2.ui.theme.FactComposable
import com.example.funfacttheme2.ui.theme.FactsViewModel
import com.example.funfacttheme2.ui.theme.TextComponent
import com.example.funfacttheme2.ui.theme.TextWithShadow
import com.example.funfacttheme2.ui.theme.TopBar

@Composable
fun WelcomeScreen(username: String?, animalSelected: String?) {
    println("=====Inside+WelcomeScreen")
    println("=====$username and $animalSelected")
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
       Column(
           modifier = Modifier
               .fillMaxSize()
               .padding(18.dp)
       ) {
           TopBar(value = "Welcome $username\uD83D\uDE0D")

           TextComponent(textValue = "Thank You for sharing your data", textSize = 24.sp)

           Spacer(modifier = Modifier.size(60.dp))

           val finalText = if (animalSelected == "Cat") "You are a Cat Lover" else "You are a Dog Lover"

           TextWithShadow(value = finalText)

           val factsViewModel : FactsViewModel = viewModel()
           FactComposable(
               value = factsViewModel.generateRandomFacts(animalSelected!!)
           )
       }
    }
}

@Preview
@Composable
fun WelcomeScreenPreview() {
    WelcomeScreen("username", "animalSelected")
}