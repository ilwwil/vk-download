package ru.vkdownload.mvp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import ru.vkdownload.mvp.data.model.App
import ru.vkdownload.mvp.ui.catalog.CatalogScreen
import ru.vkdownload.mvp.ui.catalog.fakeApps
import ru.vkdownload.mvp.ui.appdetails.AppDetailsScreen
import ru.vkdownload.mvp.ui.onboarding.OnboardingScreen

@Composable
fun NavGraph() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "onboarding"
    ) {

        // Онбординг
        composable("onboarding") {
            OnboardingScreen(
                onContinue = {
                    navController.navigate("catalog") {
                        popUpTo("onboarding") { inclusive = true }
                    }
                }
            )
        }

        // Каталог
        composable("catalog") {
            CatalogScreen(
                apps = fakeApps,
                onAppClick = { appId: String ->
                    navController.navigate("details/$appId")
                }
            )
        }

        // Детали приложения
        composable(
            route = "details/{appId}",
            arguments = listOf(
                navArgument("appId") {
                    type = NavType.StringType
                }
            )
        ) { backStackEntry ->
            val appId = backStackEntry.arguments?.getString("appId")
            val app: App = fakeApps.first { it.id == appId }

            AppDetailsScreen(
                app = app,
                onBackClick = { navController.popBackStack() }
            )
        }
    }
}
