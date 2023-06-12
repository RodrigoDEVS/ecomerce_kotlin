package com.rodrigo.ecomerceappmvvm.presentation.screens.auth.register.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults.cardColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.rodrigo.ecomerceappmvvm.R
import com.rodrigo.ecomerceappmvvm.presentation.components.DefaultButton
import com.rodrigo.ecomerceappmvvm.presentation.components.DefaultTextField
import com.rodrigo.ecomerceappmvvm.presentation.screens.auth.register.RegisterPage

@Composable
fun RegisterContent(paddingValues: PaddingValues){
    Box(modifier = Modifier
        .padding(
            paddingValues = paddingValues
        )
        .fillMaxSize()){
        Image(
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
            painter = painterResource(id = R.drawable.banner_form),
            contentDescription = "Imagen de Fondo",
            colorFilter = ColorFilter.colorMatrix(
                ColorMatrix().apply{
                    setToScale(0.5f, 0.5f, 0.5f, 1f)
                    }
                )
            )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier
                    .height(100.dp)
                    .width(100.dp),
                painter = painterResource(id = R.drawable.user_image),
                contentDescription = "")
            Text(
                text = stringResource(id = R.string.select_image),
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = Color.White
            )
            Spacer(modifier = Modifier.weight(1f))
            Card(
                modifier = Modifier
                    .fillMaxWidth(),
                shape = RoundedCornerShape(
                    topStart = 15.dp,
                    topEnd = 15.dp
                ),
                colors = cardColors(containerColor = Color.LightGray.copy(alpha = 0.8f))
            ) {
                Column(modifier = Modifier
                    .padding(25.dp)
                    .verticalScroll(rememberScrollState())) {
                    Text(text = stringResource(id = R.string.form_register).uppercase(),
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp)
                    DefaultTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = "",
                        onValueChange = {},
                        label = stringResource(id = R.string.form_names),
                        icon = Icons.Default.Person
                    )
                    DefaultTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = "",
                        onValueChange = {},
                        label = stringResource(id = R.string.form_lastnames),
                        icon = Icons.Outlined.Person
                    )
                    DefaultTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = "",
                        onValueChange = {},
                        label = stringResource(id = R.string.form_email),
                        icon = Icons.Default.Email,
                        keyboardType = KeyboardType.Email
                    )
                    DefaultTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = "",
                        onValueChange = {},
                        label = stringResource(id = R.string.form_phone),
                        icon = Icons.Default.Phone,
                        keyboardType = KeyboardType.Number
                    )
                    DefaultTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = "",
                        onValueChange = {},
                        label = stringResource(id = R.string.password),
                        icon = Icons.Default.Lock,
                        keyboardType = KeyboardType.Password
                    )
                    DefaultTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = "",
                        onValueChange = {},
                        label = stringResource(id = R.string.form_confirm_password),
                        icon = Icons.Outlined.Lock,
                        keyboardType = KeyboardType.Password
                    )
                    DefaultButton(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 10.dp),
                        onClick = {  },
                        text = stringResource(id = R.string.form_confirm).uppercase())
                }
            }
        }
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun RegisterPagePreview(){
    RegisterPage(rememberNavController())
}