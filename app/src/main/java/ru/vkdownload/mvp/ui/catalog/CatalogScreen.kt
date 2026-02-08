package ru.vkdownload.mvp.ui.catalog

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.vkdownload.mvp.data.model.App

@Composable
fun CatalogScreen(
    apps: List<App>,
    onAppClick: (String) -> Unit
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(apps) { app ->
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onAppClick(app.id) }
                    .padding(vertical = 12.dp)
            ) {
                Text(text = app.name)
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = app.shortDescription)
                Spacer(modifier = Modifier.height(2.dp))
                Text(text = app.category)
            }
        }
    }
}
