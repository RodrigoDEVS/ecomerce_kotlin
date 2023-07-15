package com.rodrigo.ecomerceappmvvm.presentation.screens.auth.register

import androidx.compose.foundation.background
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.rodrigo.ecomerceappmvvm.presentation.components.DefaultTopBar
import com.rodrigo.ecomerceappmvvm.presentation.screens.auth.register.components.Register
import com.rodrigo.ecomerceappmvvm.presentation.screens.auth.register.components.RegisterContent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterPage(navController: NavHostController){
    Scaffold(
        topBar = {
            DefaultTopBar(
                title = "Página de Registro",
                upAvailable = true,
                navController = navController
            )
        }
    ) {
        paddingValues -> RegisterContent(paddingValues = paddingValues)
    }
    Register(navController = navController)
}
@Preview(showSystemUi = true, showBackground = true)
@Composable
fun ShowRegisterPage(){
    RegisterPage(rememberNavController())
}