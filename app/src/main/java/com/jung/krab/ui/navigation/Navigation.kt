package com.jung.krab.ui.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposeNode
import androidx.compose.ui.Modifier
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jung.krab.ui.page.loginPage
import com.jung.krab.ui.page.tutorial.TutorialPage

@Composable
fun navigation(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
    NavHost(
        navController = navController,
        modifier = Modifier.padding(),
        startDestination = Route.Tutorial.name,
        enterTransition = {
            slideInHorizontally(
                initialOffsetX = { 1000 }, // 오른쪽에서 왼쪽으로 이동
                animationSpec = tween(700) // 애니메이션 시간 설정
            ) + fadeIn(animationSpec = tween(700)) // 페이드 인 애니메이션 추가
        },
        exitTransition = {
            slideOutHorizontally(
                targetOffsetX = { -1000 }, // 왼쪽으로 빠져나가기
                animationSpec = tween(700)
            ) + fadeOut(animationSpec = tween(700))
        },
        popEnterTransition = {
            slideInHorizontally(
                initialOffsetX = { -1000 }, // 왼쪽에서 들어오기
                animationSpec = tween(700)
            ) + fadeIn(animationSpec = tween(700))
        },
        popExitTransition = {
            slideOutHorizontally(
                targetOffsetX = { 1000 }, // 오른쪽으로 나가기
                animationSpec = tween(700)
            ) + fadeOut(animationSpec = tween(700))
        }
    ){
        composable(Route.Tutorial.name) { TutorialPage(modifier, navController) }
        composable(Route.Login.name) { loginPage(modifier, navController) }
    }
}
