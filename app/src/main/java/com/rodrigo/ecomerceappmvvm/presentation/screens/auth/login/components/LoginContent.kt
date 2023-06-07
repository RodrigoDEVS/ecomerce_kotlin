package com.rodrigo.ecomerceappmvvm.presentation.screens.auth.login.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rodrigo.ecomerceappmvvm.R
import com.rodrigo.ecomerceappmvvm.presentation.ui.theme.ButtonsIndigo

@Composable
fun LoginContent(paddingValues: PaddingValues){
    Box(modifier = Modifier.padding(paddingValues = paddingValues)){
        Image(
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
            painter = painterResource(id = R.drawable.banner),
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
                .padding(top = 60.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier
                    .height(100.dp)
                    .width(100.dp),
                painter = painterResource(id = R.drawable.shopping_cart_blue),
                contentDescription = "Logo")
            Text(
                modifier = Modifier.padding(top = 10.dp),
                text = stringResource(id = R.string.logo_title).uppercase(),
                fontWeight = FontWeight.Bold,
                color = Color.White,
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.weight(1f))
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(320.dp),
                shape = RoundedCornerShape(
                    topStart = 15.dp, topEnd = 15.dp
                ),
                colors = CardDefaults.cardColors(containerColor = Color.LightGray.copy(alpha = 0.8f))
            ) {
                Column(modifier = Modifier.padding(25.dp)) {
                    Text(text = stringResource(id = R.string.login_title).uppercase(),
                        fontWeight = FontWeight.Bold, fontSize = 18.sp)
                    BasicTextField(
                        modifier = Modifier
                            .padding(top = 20.dp, bottom = 20.dp)
                            .fillMaxWidth()
                            .height(40.dp)
                            .drawBehind {
                                val strokeWith = 1.dp.toPx()
                                val y = size.height - strokeWith / 2
                                drawLine(
                                    color = Color.Gray,
                                    start = Offset(0f, y),
                                    end = Offset(size.width, y),
                                    strokeWidth = strokeWith
                                )
                            },
                        value = "", onValueChange = {}, decorationBox = {
                            Row(
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    tint = ButtonsIndigo,
                                    modifier = Modifier.padding(end = 5.dp),
                                    imageVector = Icons.Default.Email, contentDescription = "")
                                Text(text = stringResource(id = R.string.email), color = Color.Gray)
                            }
                        })
                    BasicTextField(
                        modifier = Modifier
                            .padding(bottom = 20.dp)
                            .height(40.dp)
                            .fillMaxWidth()
                            .border(
                                width = 1.dp,
                                color = Color.Gray,
                                shape = RoundedCornerShape(4.dp)
                            ),
                        value = "", onValueChange = {},
                        decorationBox = {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    tint = ButtonsIndigo,
                                    modifier = Modifier.padding(end = 5.dp),
                                    imageVector = Icons.Default.Lock, contentDescription = "")
                                Text(text = stringResource(id = R.string.password),
                                    color = Color.Gray)
                            }
                        })
                    Button(
                        colors = ButtonDefaults.buttonColors(containerColor = ButtonsIndigo),
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(10.dp),
                        onClick = { }) {
                        Text(text = stringResource(id = R.string.login_button))
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 30.dp),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            modifier = Modifier.padding(end = 10.dp),
                            text = stringResource(id = R.string.have_account)
                        )
                        Text(text = stringResource(id = R.string.register), color = Color.Blue,
                            fontWeight = FontWeight.Bold, fontStyle = FontStyle.Italic)
                    }
                }
            }
        }
    }
}