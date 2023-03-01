package com.gudmal.storagemanagement.utils.navigation

sealed class Screen(val route: String) {
    object LoginScreenRoute: Screen(LOGIN_SCREEN)
    object DashboardScreenRoute: Screen(DASHBOARD_SCREEN)
}