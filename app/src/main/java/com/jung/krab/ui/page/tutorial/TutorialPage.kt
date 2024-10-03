package com.jung.krab.ui.page.tutorial

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.jung.krab.R
import com.jung.krab.ui.component.gBtnwFont
import com.jung.krab.ui.component.txtBlack36
import com.jung.krab.ui.navigation.Route
import com.jung.krab.ui.previewparam.ModifierPreviewParam

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TutorialPage(
    modifier: Modifier,
    navController: NavController
) {
    val pagerState = rememberPagerState(pageCount = { 4 }, initialPage = 0)
    Column(modifier = modifier.fillMaxSize()) {
        Spacer(modifier = Modifier.height(18.dp))
        txtBlack36(stringResource(R.string.guide), Modifier.align(Alignment.CenterHorizontally))

        HorizontalPager(
            state = pagerState, modifier = Modifier
                .weight(1f)
                .fillMaxSize()
        ) { page ->
            when (page) {
                0 -> linkPage()

                1 -> folderPage()

                2 -> friendPage()

                3 -> chatPage()
            }
        }

        PagerIndicator(pagerState, Modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.height(34.dp))

        gBtnwFont(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth()
                .height(90.dp)
                .padding(start = 31.dp, end = 31.dp, bottom = 29.dp)
        ) {
            navController.navigate(Route.Login.name)
        }
    }
}
@OptIn(ExperimentalFoundationApi::class)
@Preview(showBackground = true)
@Composable
fun PreviewTutorialPage(
    @PreviewParameter(ModifierPreviewParam::class) modifier: Modifier,
) {
    val pagerState = rememberPagerState(pageCount = { 4 }, initialPage = 0)
    Column(modifier = modifier.fillMaxSize()) {
        Spacer(modifier = Modifier.height(18.dp))
        txtBlack36(stringResource(R.string.guide), Modifier.align(Alignment.CenterHorizontally))

        HorizontalPager(
            state = pagerState, modifier = Modifier
                .weight(1f)
                .fillMaxSize()
        ) { page ->
            when (page) {
                0 -> linkPage()

                1 -> folderPage()

                2 -> friendPage()

                3 -> chatPage()
            }
        }

        PagerIndicator(pagerState, Modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.height(34.dp))

        gBtnwFont(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth()
                .height(90.dp)
                .padding(start = 31.dp, end = 31.dp, bottom = 29.dp)
        ) {
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PagerIndicator(pagerState: PagerState, modifier: Modifier) {
    Row(modifier = modifier) {
        repeat(pagerState.pageCount) { iteration ->
            if (iteration == pagerState.currentPage)
                Image(
                    painter = painterResource(R.drawable.selected_dot),
                    contentDescription = "selected"
                )
            else
                Image(
                    painter = painterResource(R.drawable.unselected_dot),
                    contentDescription = "unselected"
                )
            Spacer(modifier = Modifier.width(19.dp))
        }
    }
}