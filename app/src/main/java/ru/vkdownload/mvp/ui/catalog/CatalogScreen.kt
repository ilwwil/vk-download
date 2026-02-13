package ru.vkdownload.mvp.ui.catalog

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.vkdownload.mvp.data.model.App
import ru.vkdownload.mvp.ui.theme.Typography
import androidx.compose.ui.text.font.FontWeight


@Composable
fun CatalogScreen(
    apps: List<App>,
    onAppClick: (String) -> Unit,
    onCategoriesClick: () -> Unit,
    currentCategory: String?
) {
    Column(modifier = Modifier.fillMaxSize()) {

        Button(
            onClick = onCategoriesClick,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text("Категории")
        }

        if (currentCategory != null) {
            Text(
                text = "Текущая категория: $currentCategory",
                modifier = Modifier.padding(horizontal = 16.dp),
                style = MaterialTheme.typography.titleMedium
            )
            Spacer(modifier = Modifier.height(8.dp))
        }

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
                    Text(
                        text = app.name,
                        style = Typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(text = app.shortDescription)
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(
                        text = app.category,
                        style = Typography.labelSmall,
                    )
                }
            }
        }
    }
}

