package com.agilefreaks.summer_practice_android.components.tv.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusProperties
import androidx.tv.material3.Button
import androidx.tv.material3.ExperimentalTvMaterial3Api

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun TvHomeScreen(
    menuItemFocusRequester: FocusRequester
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Button(onClick = { /*TODO*/ },
        modifier = Modifier.focusProperties {
            left = menuItemFocusRequester
        }
            ) {
            Text(text = "Home")
        }
    }
}