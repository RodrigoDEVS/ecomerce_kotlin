package com.rodrigo.ecomerceappmvvm.presentation.screens.home

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.rodrigo.ecomerceappmvvm.presentation.screens.home.components.HomeContent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePage(navController: NavHostController){
    Scaffold() {
            paddingValues ->  HomeContent(navHostController = navController, paddingValues = paddingValues)
    }
}