package ru.vkdownload.mvp.ui.onboarding

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun OnboardingScreen(
    onContinue: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // Логотип (пока текст-заглушка)
        Text(
            text = "RuStore",
            fontSize = 32.sp
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Приветственный текст
        Text(
            text = "Добро пожаловать в RuStore"
        )

        Spacer(modifier = Modifier.height(32.dp))

        // Кнопка перехода в каталог
        Button(onClick = onContinue) {
            Text(text = "Перейти к приложениям")
        }
    }
}
