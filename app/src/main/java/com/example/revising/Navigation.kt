package com.example.revising

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.revising.Datas.AGE_KEY
import com.example.revising.Datas.DESC_KEY
import com.example.revising.Datas.Routes
import com.example.revising.Datas.TEXT_KEY
import com.example.revising.Screens.DetailedScreen
import com.example.revising.Screens.MainScreen

@RequiresApi(Build.VERSION_CODES.S)
@Composable
fun Navigation(navigation: NavHostController) {

    NavHost(navController = navigation, startDestination = Routes.MainScreen.route) {
        composable(Routes.MainScreen.route) { backstak ->
            MainScreen(navigation)
        }
        composable(
            route = Routes.DetailedScreen.route,
            arguments = listOf(
                navArgument(TEXT_KEY) {
                    type = NavType.StringType
                },
                navArgument(AGE_KEY) {
                    type = NavType.IntType
                },
                navArgument(DESC_KEY) {
                    type = NavType.StringType
                }
            )
        ) {
            val text = it.arguments?.getString(TEXT_KEY).toString()
            val age = it.arguments?.getInt(AGE_KEY)
            val desc = it.arguments?.getString(DESC_KEY).toString()

            DetailedScreen(navigation, text, age, desc)

        }

    }
}