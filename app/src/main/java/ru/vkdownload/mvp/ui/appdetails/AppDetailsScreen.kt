package ru.vkdownload.mvp.ui.appdetails

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ru.vkdownload.mvp.R
import ru.vkdownload.mvp.data.model.App

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppDetailsScreen(
    app: App,
    navController: NavController,
    onBackClick: () -> Unit
) {

    val screenshots = listOf(
        R.drawable.screenshot_1,
        R.drawable.screenshot_2,
        R.drawable.screenshot_3
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(app.name) },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Назад"
                        )
                    }
                }
            )
        },
        bottomBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Button(
                    onClick = { /* TODO install */ },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Установить")
                }
            }
        }
    ) { padding ->

        LazyColumn(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            item {
                Row(verticalAlignment = Alignment.CenterVertically) {

                    Image(
                        painter = painterResource(id = R.drawable.app_icon),
                        contentDescription = null,
                        modifier = Modifier.size(80.dp)
                    )

                    Spacer(modifier = Modifier.width(16.dp))

                    Column {
                        Text(
                            text = app.name,
                            style = MaterialTheme.typography.titleLarge
                        )

                        Text(
                            text = "VK Download Inc.",
                            style = MaterialTheme.typography.bodyMedium
                        )

                        Text(
                            text = "12+",
                            style = MaterialTheme.typography.labelMedium
                        )
                    }
                }
            }

            item {
                Text(
                    text = "Описание",
                    style = MaterialTheme.typography.titleMedium
                )
            }

            item {
                Text(
                    text = app.shortDescription,
                    style = MaterialTheme.typography.bodyLarge
                )
            }

            item {
                Text(
                    text = "Категория: ${app.category}",
                    style = MaterialTheme.typography.bodyMedium
                )
            }

            item {
                Text(
                    text = "Скриншоты",
                    style = MaterialTheme.typography.titleMedium
                )
            }

            item {
                val screenshotsList = remember { screenshots }

                if (screenshotsList.isNotEmpty()) {
                    LazyRow(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                        itemsIndexed(screenshotsList, key = { _, image -> image }) { index, image ->
                            val painter = painterResource(id = image)

                            Image(
                                painter = painter,
                                contentDescription = null,
                                modifier = Modifier
                                    .height(400.dp)
                                    .width(220.dp)
                                    .clickable {
                                        if (navController.currentBackStackEntry?.destination?.route !=
                                            "screenshots/{appId}/{startIndex}"
                                        ) {
                                            navController.navigate("screenshots/${app.id}/$index")
                                        }
                                    }
                            )
                        }
                    }
                }
            }



            item {
                Spacer(modifier = Modifier.height(80.dp))
            }
        }
    }
}
