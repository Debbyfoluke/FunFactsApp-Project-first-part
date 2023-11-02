package com.example.funfacttheme2.ui.theme.screen

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.funfacttheme2.ui.theme.UserInputViewModel


@Composable
fun FunFactsNavigationGraph(userInputViewModel: UserInputViewModel = viewModel()){
    val navController = rememberNavController()

    NavHost(navController = navController , startDestination = Routes.USER_INPUT_SCREEN, ) {

        composable(Routes.USER_INPUT_SCREEN){
            UserInputScreen(userInputViewModel, showWelcomeScreen = {
                println("Coming_inside_showWelcomeScreen")
                println(it.first)
                println(it.second)
                navController.navigate(Routes.WELCOME_SCREEN+"/${it.first}/${it.second}")
            })
        }

        composable("${Routes.WELCOME_SCREEN}/{${Routes.USER_NAME}}/{${Routes.ANIMAl_SELECTED}}",
                arguments = listOf(
                navArgument(name = Routes.USER_NAME){type = NavType.StringType},
                navArgument(name = Routes.ANIMAl_SELECTED){type = NavType.StringType}
                )
        ){
            val username = it?.arguments?.getString(Routes.USER_NAME)
            val animalSelected = it?.arguments?.getString(Routes.ANIMAl_SELECTED)
            WelcomeScreen(username, animalSelected)
        }
    }
}