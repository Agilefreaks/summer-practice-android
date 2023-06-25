package com.agilefreaks.summer_practice_android.components.mobile

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.agilefreaks.summer_practice_android.NavItem
import com.agilefreaks.summer_practice_android.components.mobile.freaks.FreaksScreen
import com.agilefreaks.summer_practice_android.components.mobile.home.HomeScreen
import com.agilefreaks.summer_practice_android.components.mobile.profile.ProfileScreen
import com.agilefreaks.summer_practice_android.ui.theme.SummerPracticeAndroidTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MobileFreaksApp() {
    val navController = rememberNavController()
    val currentBackStackEntry by navController.currentBackStackEntryAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Freaks List")
                }
            )
        },
        bottomBar = {
            NavigationBar {
                BottomNavigationItem(
                    title = NavItem.Home.title,
                    iconRes = NavItem.Home.iconRes,
                    selected = currentBackStackEntry?.destination?.route == NavItem.Home.screen_route,
                    onClick = { navController.navigate(NavItem.Home.screen_route) }
                )
                BottomNavigationItem(
                    title = NavItem.Freaks.title,
                    iconRes = NavItem.Freaks.iconRes,
                    selected = currentBackStackEntry?.destination?.route == NavItem.Freaks.screen_route,
                    onClick = { navController.navigate(NavItem.Freaks.screen_route) }
                )
                BottomNavigationItem(
                    title = NavItem.Profile.title,
                    iconRes = NavItem.Profile.iconRes,
                    selected = currentBackStackEntry?.destination?.route == NavItem.Profile.screen_route,
                    onClick = { navController.navigate(NavItem.Profile.screen_route) }
                )
            }
        }
    ) {
        NavHost(
            startDestination = NavItem.Freaks.screen_route,
            navController = navController,
            modifier = Modifier.padding(it)
        ) {
            composable(NavItem.Home.screen_route) {
                HomeScreen()
            }
            composable(NavItem.Freaks.screen_route) {
                FreaksScreen()
            }
            composable(NavItem.Profile.screen_route) {
                ProfileScreen()
            }
        }
    }
}

@Preview
@Composable
fun FreaksAppPreview() {
    SummerPracticeAndroidTheme {
        MobileFreaksApp()
    }
}