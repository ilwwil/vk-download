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
import ru.vkdownload.mvp.ui.categories.CategoriesScreen
import ru.vkdownload.mvp.ui.screenshots.ScreenshotsScreen


@Composable
fun NavGraph() {
    val navController = rememberNavController()

    val categories = fakeApps
        .groupBy { it.category }
        .map { (category, apps) ->
            category to apps.size
        }

    NavHost(
        navController = navController,
        startDestination = "onboarding"
    ) {
        composable("onboarding") {
            OnboardingScreen(
                onContinue = {
                    navController.navigate("catalog") {
                        popUpTo("onboarding") { inclusive = true }
                    }
                }
            )
        }

        composable(
            route = "catalog",
        ) {
            CatalogScreen(
                apps = fakeApps,
                onAppClick = { appId ->
                    navController.navigate("details/$appId")
                },
                onCategoriesClick = {
                    navController.navigate("categories")
                },
                currentCategory = null,
                onClearCategory = { }
            )
        }

        composable(
            route = "catalog/{category}",
            arguments = listOf(
                navArgument("category") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val category = backStackEntry.arguments?.getString("category")
            val filteredApps = fakeApps.filter { it.category == category }

            CatalogScreen(
                apps = filteredApps,
                onAppClick = { appId ->
                    navController.navigate("details/$appId")
                },
                onCategoriesClick = {
                    navController.navigate("categories")
                },
                currentCategory = category,
                onClearCategory = {
                    navController.navigate("catalog") {
                        popUpTo("catalog") { inclusive = true }
                    }
                }
            )
        }

        composable("categories") {
            CategoriesScreen(
                categories = categories,
                onCategoryClick = { category ->
                    navController.navigate("catalog/$category") {
                        popUpTo("catalog")
                        launchSingleTop = true
                    }
                },
                onClearCategory = {
                    navController.navigate("catalog") {
                        popUpTo("catalog") { inclusive = true }
                        launchSingleTop = true
                    }
                }
            )
        }

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
                navController = navController,
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }

        composable(
            route = "screenshots/{appId}/{startIndex}",
            arguments = listOf(
                navArgument("appId") { type = NavType.StringType },
                navArgument("startIndex") { type = NavType.IntType }
            )
        ) { backStackEntry ->
            val appId = backStackEntry.arguments?.getString("appId") ?: return@composable
            val startIndex = backStackEntry.arguments?.getInt("startIndex") ?: 0
            val app = fakeApps.first { it.id == appId }

            ScreenshotsScreen(
                screenshots = app.screenshots,
                startIndex = startIndex,
                onBackClick = { navController.popBackStack() }
            )
        }
    }
}
