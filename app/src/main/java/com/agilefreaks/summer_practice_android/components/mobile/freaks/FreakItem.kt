package com.agilefreaks.summer_practice_android.components.mobile.freaks

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.agilefreaks.summer_practice_android.R
import com.agilefreaks.summer_practice_android.ui.theme.SummerPracticeAndroidTheme

@Composable
fun FreakItem(
    name: String,
    @DrawableRes avatarResource: Int,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(
                id = avatarResource
            ),
            contentDescription = "avatar",
            modifier = Modifier.size(56.dp)
        )
        Spacer(modifier = Modifier.width(24.dp))
        Text(
            text = name,
            color = MaterialTheme.colorScheme.onBackground,
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun FreakPreview() {
    SummerPracticeAndroidTheme {
        FreakItem(
            "Sandra",
            R.drawable.avatar_sandra
        )
    }
}