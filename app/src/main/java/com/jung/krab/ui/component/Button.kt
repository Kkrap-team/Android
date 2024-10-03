package com.jung.krab.ui.component

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.jung.krab.R

@Composable
fun gBtnwFont(modifier: Modifier = Modifier,
              onClick:()->Unit){
    Button(
        onClick = onClick,
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(containerColor = colorResource(R.color.main))
    ){
        txtWhite32(stringResource(R.string.login), modifier = Modifier.padding(bottom = 16.dp))
    }
}