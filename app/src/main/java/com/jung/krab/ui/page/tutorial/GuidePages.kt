package com.jung.krab.ui.page.tutorial

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jung.krab.R
import com.jung.krab.ui.component.txtBlack64SB
import com.jung.krab.ui.component.txtGreen64SB

@Preview(showBackground = true)
@Composable
fun linkPage() {
    Column {
        Spacer(modifier = Modifier.height(167.dp))
        Column(modifier = Modifier.padding(start = 88.dp)) {
            txtBlack64SB("저장하고 싶은")
            Row {
                txtGreen64SB("링크")
                txtBlack64SB("를")
                Image(
                    painter = painterResource(R.drawable.share),
                    contentDescription = "share",
                    modifier = Modifier
                        .size(height = 21.dp, width = 20.dp)
                        .align(Alignment.CenterVertically)
                )
            }
            txtBlack64SB("모두 불러오세요")
        }

        Image(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxSize(),
            painter = painterResource(R.drawable.link_img),
            contentDescription = "링크 가이드"
        )

    }
}
@Preview(showBackground = true)
@Composable
fun folderPage() {
    Column {
        Spacer(modifier = Modifier.height(167.dp))
        Column(modifier = Modifier.padding(start = 88.dp)) {
            txtBlack64SB("저장된 링크들을")
            txtGreen64SB("카테코리별")
            Row {
                txtGreen64SB("폴더")
                txtBlack64SB("로 정리해보세요")
            }
        }

        Image(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxSize(),
            painter = painterResource(R.drawable.folder_img),
            contentDescription = "폴더 가이드"
        )

    }
}

@Preview(showBackground = true)
@Composable
fun friendPage() {
    Column {
        Spacer(modifier = Modifier.height(167.dp))
        Column(modifier = Modifier.padding(start = 88.dp)) {
            txtBlack64SB("폴더를 공유하고")
            Row {
                txtBlack64SB("싶은")
                txtGreen64SB(" 친구를")
            }
            Row {
                txtGreen64SB("초대")
                txtBlack64SB("해 보세요")
            }
        }

        Image(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxSize(),
            painter = painterResource(R.drawable.friend_img),
            contentDescription = "친구 가이드"
        )

    }
}

@Preview(showBackground = true)
@Composable
fun chatPage() {
    Column {
        Spacer(modifier = Modifier.height(167.dp))
        Column(modifier = Modifier.padding(start = 88.dp)) {
            txtBlack64SB("친구와 폴더를")
            Row {
                txtGreen64SB("공유")
                txtBlack64SB("하며")
            }
            Row {
                txtGreen64SB("채팅")
                txtBlack64SB("해 보세요")
            }
        }

        Image(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxSize(),
            painter = painterResource(R.drawable.chat_img),
            contentDescription = "공유 가이드"
        )

    }
}