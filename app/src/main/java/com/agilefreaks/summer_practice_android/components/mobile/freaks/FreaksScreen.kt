package com.agilefreaks.summer_practice_android.components.mobile.freaks

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.agilefreaks.summer_practice_android.domain.mockedFreaksList
import com.agilefreaks.summer_practice_android.ui.theme.SummerPracticeAndroidTheme

@Composable
fun FreaksScreen(
    modifier: Modifier = Modifier
) {
    val freaks = mockedFreaksList()

    LazyColumn(modifier = modifier
        .padding(24.dp)
        .border(
            width = 1.dp,
            color = MaterialTheme.colorScheme.onBackground,
            shape = RoundedCornerShape(20.dp)
        ), contentPadding = PaddingValues(horizontal = 16.dp), content = {
        items(freaks.count()) { index ->
            Column {
                Spacer(modifier = Modifier.height(24.dp))
                FreakItem(
                    name = freaks[index].name, avatarResource = freaks[index].avatarResource
                )
                Spacer(modifier = Modifier.height(16.dp))
                Divider()
            }
        }
    })
}

@Preview(showBackground = true)
@Composable
fun FreaksScreenPreview() {
    SummerPracticeAndroidTheme {
        FreaksScreen()
    }
}