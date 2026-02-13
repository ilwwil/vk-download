package ru.vkdownload.mvp.ui.catalog

import ru.vkdownload.mvp.data.model.App
import ru.vkdownload.mvp.R

val fakeApps = listOf(
    App(
        id = "finance_1",
        name = "VK Pay",
        shortDescription = "Платежи, переводы и оплата услуг",
        category = "Финансы",
        screenshots = listOf(R.drawable.screenshot_1, R.drawable.screenshot_2, R.drawable.screenshot_3)
    ),

    App(
        id = "tools_1",
        name = "Фонарик",
        shortDescription = "Простой и удобный фонарик",
        category = "Инструменты",
        screenshots = listOf(R.drawable.screenshot_1, R.drawable.screenshot_2, R.drawable.screenshot_3)
    ),

    App(
        id = "games_1",
        name = "2048",
        shortDescription = "Классическая числовая головоломка",
        category = "Игры",
        screenshots = listOf(R.drawable.screenshot_1, R.drawable.screenshot_2, R.drawable.screenshot_3)
    ),

    App(
        id = "gov_1",
        name = "Госуслуги",
        shortDescription = "Доступ к государственным сервисам",
        category = "Государственные",
        screenshots = listOf(R.drawable.screenshot_1, R.drawable.screenshot_2, R.drawable.screenshot_3)
    ),

    App(
        id = "transport_1",
        name = "Навигатор",
        shortDescription = "Маршруты, пробки и общественный транспорт",
        category = "Транспорт",
        screenshots = listOf(R.drawable.screenshot_1, R.drawable.screenshot_2, R.drawable.screenshot_3)
    )
)
