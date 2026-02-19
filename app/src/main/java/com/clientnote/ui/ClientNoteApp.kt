package com.clientnote.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.clientnote.data.MockData
import com.clientnote.ui.screens.CopierDetailScreen
import com.clientnote.ui.screens.CustomerDetailScreen
import com.clientnote.ui.screens.CustomerListScreen

private object Routes {
    const val Customers = "customers"
    const val CustomerDetail = "customer/{customerId}"
    const val CopierDetail = "copier/{copierId}"
}

@Composable
fun ClientNoteApp() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.Customers) {
        composable(Routes.Customers) {
            CustomerListScreen(
                customers = MockData.customers,
                onClickCustomer = { customer ->
                    navController.navigate("customer/${customer.id}")
                }
            )
        }

        composable(
            route = Routes.CustomerDetail,
            arguments = listOf(navArgument("customerId") { type = NavType.LongType })
        ) { backStackEntry ->
            val customerId = backStackEntry.arguments?.getLong("customerId") ?: return@composable
            val customer = MockData.customers.firstOrNull { it.id == customerId } ?: return@composable
            val customerCopiers = MockData.copiers.filter { it.customerId == customerId }

            CustomerDetailScreen(
                customer = customer,
                copiers = customerCopiers,
                onBack = navController::popBackStack,
                onClickCopier = { copier ->
                    navController.navigate("copier/${copier.id}")
                }
            )
        }

        composable(
            route = Routes.CopierDetail,
            arguments = listOf(navArgument("copierId") { type = NavType.LongType })
        ) { backStackEntry ->
            val copierId = backStackEntry.arguments?.getLong("copierId") ?: return@composable
            val copier = MockData.copiers.firstOrNull { it.id == copierId } ?: return@composable

            CopierDetailScreen(
                copier = copier,
                repairs = MockData.repairs,
                consumables = MockData.consumables,
                onBack = navController::popBackStack
            )
        }
    }
}
