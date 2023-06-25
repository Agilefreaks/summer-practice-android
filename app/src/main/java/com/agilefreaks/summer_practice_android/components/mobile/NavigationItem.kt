package com.agilefreaks.summer_practice_android.components.mobile

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.agilefreaks.summer_practice_android.R
import com.agilefreaks.summer_practice_android.ui.theme.Grey70
import com.agilefreaks.summer_practice_android.ui.theme.SummerPracticeAndroidTheme

@Composable
fun RowScope.NavigationItem(
    title: String,
    @DrawableRes iconRes: Int,
    selected: Boolean,
    onClick: () -> Unit
) {
    NavigationBarItem(
        colors = NavigationBarItemDefaults.colors(
            selectedIconColor = MaterialTheme.colorScheme.primary,
            unselectedIconColor = Grey70
        ),
        icon = {
            Icon(
                modifier = Modifier.size(24.dp),
                painter = painterResource(id = iconRes),
                contentDescription = title,
            )
        },
        label = { Text(text = title, color = LocalContentColor.current) },
        selected = selected,
        onClick = onClick
    )
}

@Preview(showBackground = true)
@Composable
fun NavigationItemPreview() {
    SummerPracticeAndroidTheme {
        Row(Modifier.height(80.dp)) {
            NavigationItem(
                title = "Home",
                iconRes = R.drawable.home,
                selected = true,
                onClick = {}
            )
        }
    }
}