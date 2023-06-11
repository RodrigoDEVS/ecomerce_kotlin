package com.rodrigo.ecomerceappmvvm.presentation.screens.navigation.graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.rodrigo.ecomerceappmvvm.presentation.screens.auth.login.LoginPage
import com.rodrigo.ecomerceappmvvm.presentation.screens.auth.register.RegisterPage
import com.rodrigo.ecomerceappmvvm.presentation.screens.navigation.Graph
import com.rodrigo.ecomerceappmvvm.presentation.screens.navigation.screen.AuthScreen

fun NavGraphBuilder.AuthNavGraph(navController: NavHostController){
    navigation(
        route = Graph.AUTH,
        startDestination = AuthScreen.Login.route
    ){
        composable(route = AuthScreen.Login.route){
            LoginPage(navController)
        }
        composable(route = AuthScreen.Register.route){
            RegisterPage(navController)
        }
    }
}