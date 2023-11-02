package com.example.funfacttheme2.ui.theme.screen

import android.inputmethodservice.Keyboard
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.funfacttheme2.R
import com.example.funfacttheme2.data.UserDataUiEvents
import com.example.funfacttheme2.ui.theme.AnimalCard
import com.example.funfacttheme2.ui.theme.ButtonComponent
import com.example.funfacttheme2.ui.theme.TextComponent
import com.example.funfacttheme2.ui.theme.TextFieldComponent
import com.example.funfacttheme2.ui.theme.TopBar
import com.example.funfacttheme2.ui.theme.UserInputViewModel


@Composable
fun UserInputScreen(
    userInputViewModel: UserInputViewModel,

    showWelcomeScreen: (valuesPair: Pair<String, String>) -> Unit = {}
) {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(18.dp)
        )
        {
            TopBar("Hi there \uD83D\uDE0A")

            TextComponent(
                textValue = "Let's learn about You !",
                textSize = 24.sp
            )

            Spacer(modifier = Modifier.size(20.dp))

            TextComponent(
                textValue = "This app will prepare a detail page based on input provided by you!",
                textSize = 18.sp
            )

            Spacer(modifier = Modifier.size(60.dp))

            TextComponent(
                textValue = "Name",
                textSize = 18.sp
            )

            Spacer(modifier = Modifier.size(10.dp))

            TextFieldComponent(onTextChanged = {
                userInputViewModel.onEvent(
                    UserDataUiEvents.UserNameEntered(it)
                )
            })

            Spacer(modifier = Modifier.size(20.dp))

            TextComponent(
                textValue = "What do you like",
                textSize = 18.sp
            )

            Row(modifier = Modifier.fillMaxWidth()) {
                AnimalCard(image = R.drawable.img, animalSelected = {
                    userInputViewModel.onEvent(
                        UserDataUiEvents.AnimalSelected(it)
                    )
                }, selected = userInputViewModel.uiState.value.animalSelected == "Cat")
                AnimalCard(image = R.drawable.img_1, animalSelected = {
                    userInputViewModel.onEvent(
                        UserDataUiEvents.AnimalSelected(it)
                    )
                }, selected = userInputViewModel.uiState.value.animalSelected == "Cat")
            }

            Spacer(modifier = Modifier.size(20.dp))

            if (!userInputViewModel.uiState.value.nameEntered.isNullOrEmpty()
                &&
                !userInputViewModel.uiState.value.animalSelected.isNullOrEmpty()
            ) {
                ButtonComponent(
                    goToDetailsScreen = {
                        println("==========ComingHere")
                        println("==========${userInputViewModel.uiState.value.nameEntered} and ${userInputViewModel.uiState.value.animalSelected}")
                    }
                )
            }
        }
    }
}

@Preview
@Composable
fun UserInputScreenPreview() {
    UserInputScreen(
        UserInputViewModel(), showWelcomeScreen = {

        }
    )
}