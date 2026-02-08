package ru.vkdownload.mvp.ui.catalog

import ru.vkdownload.mvp.data.model.App

val fakeApps = listOf(
    App(
        id = "finance_1",
        name = "VK Pay",
        shortDescription = "Платежи, переводы и оплата услуг",
        category = "Финансы"
    ),

    App(
        id = "tools_1",
        name = "Фонарик",
        shortDescription = "Простой и удобный фонарик",
        category = "Инструменты"
    ),

    App(
        id = "games_1",
        name = "2048",
        shortDescription = "Классическая числовая головоломка",
        category = "Игры"
    ),

    App(
        id = "gov_1",
        name = "Госуслуги",
        shortDescription = "Доступ к государственным сервисам",
        category = "Государственные"
    ),

    App(
        id = "transport_1",
        name = "Навигатор",
        shortDescription = "Маршруты, пробки и общественный транспорт",
        category = "Транспорт"
    )
)
