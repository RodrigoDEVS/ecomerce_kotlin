package com.rodrigo.ecomerceappmvvm.presentation.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import com.rodrigo.ecomerceappmvvm.presentation.ui.theme.ButtonsIndigo

@Composable
fun DefaultButton(
    modifier: Modifier,
    colors: ButtonColors = ButtonDefaults.buttonColors(containerColor = ButtonsIndigo),
    shape: Shape = RoundedCornerShape(10.dp),
    onClick: () -> Unit,
    text: String
){
    Button(
        modifier = modifier,
        colors = colors,
        shape = shape,
        onClick = { onClick() }) {
        Text(text = text)
    }
}
