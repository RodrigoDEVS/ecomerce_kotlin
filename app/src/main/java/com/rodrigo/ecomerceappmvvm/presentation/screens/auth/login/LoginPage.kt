package com.rodrigo.ecomerceappmvvm.presentation.screens.auth.login

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.rodrigo.ecomerceappmvvm.presentation.screens.auth.login.components.Login
import com.rodrigo.ecomerceappmvvm.presentation.screens.auth.login.components.LoginContent
import com.rodrigo.ecomerceappmvvm.presentation.ui.theme.EcomerceAppMVVMTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginPage(navController: NavHostController){
    Scaffold() {
        paddingValues -> LoginContent(navController = navController, paddingValues)
    }
    Login(navController = navController)
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LoginPagePreview() {
    EcomerceAppMVVMTheme {
        LoginPage(rememberNavController())
    }
}