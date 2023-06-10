package com.rodrigo.ecomerceappmvvm.presentation.screens.navigation.screen

sealed class AuthScreen(val route: String){
    object Login: AuthScreen("login")
    object Register: AuthScreen("register")
}
