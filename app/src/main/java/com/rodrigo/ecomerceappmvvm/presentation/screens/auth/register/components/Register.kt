package com.rodrigo.ecomerceappmvvm.presentation.screens.auth.register.components

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.rodrigo.ecomerceappmvvm.domain.util.Request
import com.rodrigo.ecomerceappmvvm.presentation.screens.auth.register.RegisterViewModel
import com.rodrigo.ecomerceappmvvm.presentation.screens.navigation.screen.AuthScreen

@Composable
fun Register(navController: NavHostController, vm: RegisterViewModel = hiltViewModel()){
    when(val response = vm.registerRequest) {
        Request.Loading -> {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }

        is Request.Success -> {
            LaunchedEffect(Unit) {
                navController.navigate(route = AuthScreen.Login.route)
            }
        }

        is Request.Failure -> {
            Toast.makeText(LocalContext.current, response.exception.message, Toast.LENGTH_SHORT)
                .show()
        }

        else -> {
            if (response != null) {
                Toast.makeText(LocalContext.current, "Error desconocido", Toast.LENGTH_SHORT).show()
            }
        }
    }
}