package com.jung.krab.ui.page

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.jung.krab.R
import com.jung.krab.ui.component.txtBlack64SB
import com.jung.krab.ui.component.txtWhite64SB

@Composable
fun loginPage(modifier: Modifier, navController: NavController) {
    Column(
        modifier = modifier
            .background(color = colorResource(R.color.main))
            .fillMaxSize()
    ) {
        Column(modifier = Modifier.padding(top = 75.dp, start = 76.dp)) {
            txtBlack64SB("일상 속 모든 것을")
            Row {
                txtBlack64SB("스")
                txtWhite64SB("크")
                txtBlack64SB("랩,")
            }
            Row {
                txtWhite64SB("크")
                txtBlack64SB("크")
                txtWhite64SB("랩")
            }
        }

        Spacer(Modifier.height(80.dp))

        Image(
            painter = painterResource(R.drawable.main_img),
            contentDescription = "main",
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .weight(1f)
        )

        Spacer(Modifier.height(96.dp))

        Button(
            colors = ButtonColors(
                containerColor = colorResource(R.color.transparent),
                contentColor = colorResource(R.color.transparent),
                disabledContentColor = colorResource(R.color.transparent),
                disabledContainerColor = colorResource(R.color.transparent),
            ),
            contentPadding = PaddingValues(0.dp),
            shape = RectangleShape,
            onClick = {},
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 95.dp, bottom = 53.dp, end = 87.dp),
        ) {
            Image(
                painter = painterResource(R.drawable.kakao_login_large_wide),
                contentDescription = "카카오 로그인"
            )
        }
    }
}