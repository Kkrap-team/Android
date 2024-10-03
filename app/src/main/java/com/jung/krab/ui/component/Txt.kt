package com.jung.krab.ui.component

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jung.krab.R

@Composable
fun txtBlack36(txt:String, modifier: Modifier = Modifier){
    Text(
        text = txt,
        color = colorResource(R.color.black),
        modifier = modifier,
        fontSize = 12.sp
    )
}

@Composable
fun txtWhite32(txt:String, modifier: Modifier = Modifier){
    Text(
        text = txt,
        color = colorResource(R.color.white),
        fontSize = 10.sp
    )
}
@Composable
fun txtBlack64SB(txt:String, modifier: Modifier = Modifier){
    Text(
        text = txt,
        color = colorResource(R.color.black),
        fontSize = 21.sp
    )
}
@Composable
fun txtGreen64SB(txt:String, modifier: Modifier = Modifier){
    Text(
        text = txt,
        color = colorResource(R.color.main),
        fontSize = 21.sp
    )
}

@Composable
fun txtWhite64SB(txt:String, modifier: Modifier = Modifier){
    Text(
        text = txt,
        color = colorResource(R.color.white),
        fontSize = 21.sp
    )
}
