package com.agilefreaks.summer_practice_android.components.tv

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.ModalNavigationDrawer
import com.agilefreaks.summer_practice_android.NavItem
import com.agilefreaks.summer_practice_android.components.tv.freaks.TvFreaksScreen
import com.agilefreaks.summer_practice_android.components.tv.home.TvHomeScreen
import com.agilefreaks.summer_practice_android.components.tv.profile.TvProfileScreen
import com.agilefreaks.summer_practice_android.popUpTo
import com.agilefreaks.summer_practice_android.ui.theme.SummerPracticeAndroidTheme
import com.agilefreaks.summer_practice_android.ui.theme.White

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun TvFreaksApp() {
    val navController = rememberNavController()
    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    val focusRequesters = remember { List(3) { FocusRequester() } }

    ModalNavigationDrawer(drawerContent = {
        Column(
            Modifier
                .background(White)
                .fillMaxHeight()
        ) {
            Spacer(Modifier.height(80.dp))
            DrawerItem(
                drawerValue = it,
                title = NavItem.Home.title,
                selected = currentBackStackEntry?.destination?.route == NavItem.Home.screen_route,
                iconRes = NavItem.Home.iconRes,
                focusRequester = focusRequesters[0]
            ) {
                navController.popUpTo(NavItem.Home.screen_route)
            }
            Spacer(Modifier.height(16.dp))
            DrawerItem(
                drawerValue = it,
                title = NavItem.Freaks.title,
                selected = currentBackStackEntry?.destination?.route == NavItem.Freaks.screen_route,
                iconRes = NavItem.Freaks.iconRes,
                focusRequester = focusRequesters[1]
            ) {
                navController.popUpTo(NavItem.Freaks.screen_route)
            }
            Spacer(Modifier.height(16.dp))
            DrawerItem(
                drawerValue = it,
                title = NavItem.Profile.title,
                selected = currentBackStackEntry?.destination?.route == NavItem.Profile.screen_route,
                iconRes = NavItem.Profile.iconRes,
                focusRequester = focusRequesters[2]
            ) {
                navController.popUpTo(NavItem.Profile.screen_route)
            }
        }
    }) {
        NavHost(
            startDestination = NavItem.Freaks.screen_route,
            navController = navController,
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 80.dp, start = 96.dp, end = 16.dp)
        ) {
            composable(NavItem.Home.screen_route) {
                TvHomeScreen(
                    focusRequesters[0]
                )
            }
            composable(NavItem.Freaks.screen_route) {
                TvFreaksScreen(
                    focusRequesters[1]
                )
            }
            composable(NavItem.Profile.screen_route) {
                TvProfileScreen(
                    focusRequesters[2]
                )
            }
        }
    }
}

@Preview
@Composable
fun TvFreaksAppPreview() {
    SummerPracticeAndroidTheme {
        TvFreaksApp()
    }
}