package com.agilefreaks.summer_practice_android

import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination

/**
 * Restore destination if it was already created.
 *
 * @param destination The destination to navigate to.
 */
fun NavController.popUpTo(destination: String) = navigate(destination) {
    popUpTo(graph.findStartDestination().id) {
        saveState = true
    }

    restoreState = true
}
