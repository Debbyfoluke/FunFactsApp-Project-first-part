package com.example.funfacttheme2.ui.theme

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.funfacttheme2.data.UserDataUiEvents
import com.example.funfacttheme2.data.UserInputScreenState
import java.util.logging.LoggingPermission

class UserInputViewModel: ViewModel() {
    var uiState = mutableStateOf(UserInputScreenState())

    companion object{
        const val TAG = "UserInputViewModel"
    }

    fun onEvent(event: UserDataUiEvents) {
        when(event) {
            is UserDataUiEvents.UserNameEntered -> {
                uiState.value = uiState.value.copy(
                    nameEntered = event.name
                )
                Log.d(TAG, "onEvent:UserNameEntered->>")
                Log.d(TAG, "${uiState.value}")
            }

            is UserDataUiEvents.AnimalSelected ->{
                uiState.value = uiState.value.copy(
                    animalSelected = event.animalSelected
                )
                Log.d(TAG, "onEvent:AnimalSelected->>")
                Log.d(TAG, "${uiState.value}")
            }

            else -> {}
        }
    }
}


