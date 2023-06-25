package com.agilefreaks.summer_practice_android.components.tv

import androidx.annotation.DrawableRes
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.tv.material3.DrawerValue
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.Icon
import androidx.tv.material3.Text
import com.agilefreaks.summer_practice_android.R
import com.agilefreaks.summer_practice_android.ui.theme.Grey70
import com.agilefreaks.summer_practice_android.ui.theme.SummerPracticeAndroidTheme

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun DrawerItem(
    drawerValue: DrawerValue,
    title: String,
    @DrawableRes iconRes: Int,
    selected: Boolean,
    focusRequester: FocusRequester,
    modifier: Modifier = Modifier,
    onFocus: () -> Unit
) {
    val hasFocus = remember { mutableStateOf(false) }
    val backgroundColor =
        if (hasFocus.value) MaterialTheme.colorScheme.primary else Color.Transparent
    val contentColor = when {
        hasFocus.value -> MaterialTheme.colorScheme.onPrimary
        selected -> MaterialTheme.colorScheme.primary
        else -> Grey70
    }

    Row(
        modifier = modifier
            .height(48.dp)
            .width(if (drawerValue == DrawerValue.Open) 265.dp else 80.dp)
            .padding(horizontal = 12.dp)
            .background(color = backgroundColor, shape = RoundedCornerShape(32.dp))
            .focusRequester(focusRequester)
            .onFocusChanged {
                hasFocus.value = it.hasFocus
                if (it.hasFocus) onFocus()
            }
            .focusable(true),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = iconRes),
            contentDescription = title,
            modifier = Modifier
                .padding(16.dp)
                .size(24.dp),
            tint = contentColor
        )
        AnimatedVisibility(visible = drawerValue == DrawerValue.Open) {
            Row {
                Spacer(modifier = Modifier.width(12.dp))
                Text(
                    text = if (drawerValue == DrawerValue.Open) title else "",
                    color = contentColor,
                    textAlign = TextAlign.Center
                )
            }
        }
    }

    LaunchedEffect(key1 = drawerValue, block = {
        if (drawerValue == DrawerValue.Open && selected) focusRequester.requestFocus()
    })
}

@OptIn(ExperimentalTvMaterial3Api::class)
@Preview(showBackground = true)
@Composable
private fun DrawerItemPreview() {
    SummerPracticeAndroidTheme {
        DrawerItem(
            drawerValue = DrawerValue.Closed,
            title = "Home",
            iconRes = R.drawable.home,
            selected = true,
            focusRequester = FocusRequester()
        ) {}
    }
}