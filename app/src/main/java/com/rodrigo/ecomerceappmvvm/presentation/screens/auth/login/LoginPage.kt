package com.rodrigo.ecomerceappmvvm.presentation.screens.auth.login

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.rodrigo.ecomerceappmvvm.presentation.screens.auth.login.components.LoginContent
import com.rodrigo.ecomerceappmvvm.presentation.ui.theme.EcomerceAppMVVMTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginPage(){
    Scaffold() {
        paddingValues -> LoginContent(paddingValues)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LoginPagePreview() {
    EcomerceAppMVVMTheme {
        LoginPage()
    }
}