package com.rodrigo.ecomerceappmvvm.presentation.screens.auth.register

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.rodrigo.ecomerceappmvvm.presentation.screens.auth.register.components.RegisterContent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterPage(){
    Scaffold() {
        paddingValues -> RegisterContent(paddingValues = paddingValues)
    }
}