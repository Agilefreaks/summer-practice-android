package com.agilefreaks.summer_practice_android.components.mobile.freaks

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.agilefreaks.summer_practice_android.domain.mockedFreaksList
import com.agilefreaks.summer_practice_android.ui.theme.SummerPracticeAndroidTheme

@Composable
fun FreaksScreen(
) {
    val freaks = mockedFreaksList()

    // TODO
}

@Preview(showBackground = true)
@Composable
fun FreaksScreenPreview() {
    SummerPracticeAndroidTheme {
        FreaksScreen()
    }
}