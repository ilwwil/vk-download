package ru.vkdownload.mvp.ui.appdetails

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.vkdownload.mvp.data.model.App

@Composable
fun AppDetailsScreen(
    app: App
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(text = app.name)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = app.shortDescription)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Категория: ${app.category}")
    }
}