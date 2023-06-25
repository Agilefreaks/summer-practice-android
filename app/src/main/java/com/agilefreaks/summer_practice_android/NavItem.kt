package com.agilefreaks.summer_practice_android

import androidx.annotation.DrawableRes

sealed class NavItem(
    val title: String,
    @DrawableRes val iconRes: Int,
    val screen_route: String
) {
    object Home : NavItem("Home", R.drawable.home, "home")
    object Freaks : NavItem("Freaks", R.drawable.freaks, "freaks")
    object Profile : NavItem("Profile", R.drawable.profile, "profile")
}