package com.rodrigo.ecomerceappmvvm.presentation.screens.home.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.rodrigo.ecomerceappmvvm.presentation.screens.home.HomePage
import com.rodrigo.ecomerceappmvvm.presentation.ui.theme.EcomerceAppMVVMTheme

@Composable
fun HomeContent(navHostController: NavHostController, paddingValues: PaddingValues){
    Box(modifier = Modifier.padding(paddingValues = paddingValues)){
        Text(text = "Home Page")
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeContentPreview() {
    EcomerceAppMVVMTheme {
        HomePage(rememberNavController())
    }
}