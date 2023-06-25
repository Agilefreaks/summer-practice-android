package com.agilefreaks.summer_practice_android.domain

import com.agilefreaks.summer_practice_android.R

data class Freak(
    val name: String,
    val avatarResource: Int,
)

fun mockedFreaksList(): List<Freak> =
    listOf(
        Freak("Calin", R.drawable.avatar_calin),
        Freak("Sandra", R.drawable.avatar_sandra),
        Freak("Calin", R.drawable.avatar_calin),
        Freak("Sandra", R.drawable.avatar_sandra),
        Freak("Calin", R.drawable.avatar_calin),
        Freak("Sandra", R.drawable.avatar_sandra),
        Freak("Calin", R.drawable.avatar_calin),
        Freak("Sandra", R.drawable.avatar_sandra),
        Freak("Calin", R.drawable.avatar_calin),
        Freak("Sandra", R.drawable.avatar_sandra),
        Freak("Calin", R.drawable.avatar_calin),
        Freak("Sandra", R.drawable.avatar_sandra),
        Freak("Calin", R.drawable.avatar_calin),
        Freak("Sandra", R.drawable.avatar_sandra),
        Freak("Calin", R.drawable.avatar_calin),
        Freak("Sandra", R.drawable.avatar_sandra),
    )