package ru.vkdownload.mvp.ui.categories

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.vkdownload.mvp.ui.theme.VKdownloadTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoriesScreen(
    categories: List<Pair<String, Int>>,
    onCategoryClick: (String) -> Unit,
    onClearCategory: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Категории") },
                actions = {
                    Button(onClick = onClearCategory) {
                        Text("Очистить")
                    }
                }
            )
        }
    ) { padding ->

        LazyColumn(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(categories) { (category, count) ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { onCategoryClick(category) }
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(text = category, style = MaterialTheme.typography.titleMedium)
                        Text(text = "Приложений: $count")
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun CategoriesScreenPreview() {
    VKdownloadTheme {
        CategoriesScreen(
            categories = listOf("Tools" to 10, "Games" to 5),
            onCategoryClick = {},
            onClearCategory = {}
        )
    }
}
