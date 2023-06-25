package com.agilefreaks.summer_practice_android.components.tv.freaks

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusProperties
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.tv.foundation.lazy.grid.TvGridCells
import androidx.tv.foundation.lazy.grid.TvLazyVerticalGrid
import androidx.tv.material3.Border
import androidx.tv.material3.CardDefaults
import androidx.tv.material3.CardLayoutDefaults
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.StandardCardLayout
import com.agilefreaks.summer_practice_android.domain.mockedFreaksList

@OptIn(ExperimentalTvMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun TvFreaksScreen(
    menuItemFocusRequester: FocusRequester
) {
    TvLazyVerticalGrid(
        modifier = Modifier.focusProperties {
            exit = {
                if (it == FocusDirection.Left) {
                    menuItemFocusRequester
                } else FocusRequester.Cancel
            }
        },
        columns = TvGridCells.Fixed(5), content = {
            items(mockedFreaksList().size) { index ->
                StandardCardLayout(
                    modifier = Modifier.padding(16.dp),
                    contentColor = CardLayoutDefaults.contentColor(contentColor = MaterialTheme.colorScheme.surface),
                    title = { Text(text = mockedFreaksList()[index].name) },
                    imageCard = {
                        CardLayoutDefaults.ImageCard(
                            colors = CardDefaults.colors(
                                containerColor = MaterialTheme.colorScheme.surface,
                            ),
                            border = CardDefaults.border(
                                focusedBorder = Border(
                                    shape = CircleShape,
                                    border = BorderStroke(
                                        width = 3.dp,
                                        color = MaterialTheme.colorScheme.primary
                                    )
                                )
                            ),
                            onClick = { },
                            interactionSource = it
                        ) {
                            Image(
                                modifier = Modifier
                                    .background(Color.Transparent)
                                    .clip(CircleShape)
                                    .size(124.dp),
                                painter = painterResource(id = mockedFreaksList()[index].avatarResource),
                                contentDescription = null
                            )
                        }
                    })
            }
        })
}