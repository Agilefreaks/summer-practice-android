package com.agilefreaks.summer_practice_android.components.mobile

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.agilefreaks.summer_practice_android.NavItem
import com.agilefreaks.summer_practice_android.ui.theme.SummerPracticeAndroidTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MobileFreaksApp() {
    val navController = rememberNavController()
    val currentBackStackEntry by navController.currentBackStackEntryAsState()

    Scaffold(
        topBar = {
            // TODO
        },
        bottomBar = {
            NavigationBar {
                // TODO
            }
        }
    ) {
        NavHost(
            startDestination = NavItem.Freaks.screen_route,
            navController = navController,
            modifier = Modifier.padding(it)
        ) {
            // TODO
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