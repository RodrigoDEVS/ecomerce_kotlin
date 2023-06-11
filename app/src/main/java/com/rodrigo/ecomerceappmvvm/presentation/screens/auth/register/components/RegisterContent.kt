package com.rodrigo.ecomerceappmvvm.presentation.screens.auth.register.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.rodrigo.ecomerceappmvvm.R
import com.rodrigo.ecomerceappmvvm.presentation.screens.auth.register.RegisterPage

@Composable
fun RegisterContent(paddingValues: PaddingValues){
    Box(modifier = Modifier){
        Text(text = "Register Page")
        Spacer(modifier = Modifier.height(20.dp))
        Image(
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
            painter = painterResource(id = R.drawable.banner),
            contentDescription = "Imagen de Fondo")
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun RegisterPagePreview(){
    RegisterPage(rememberNavController())
}