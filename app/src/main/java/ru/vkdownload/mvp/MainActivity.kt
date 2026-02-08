package ru.vkdownload.mvp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import ru.vkdownload.mvp.navigation.NavGraph
import ru.vkdownload.mvp.ui.theme.VKdownloadTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            VKdownloadTheme {
                NavGraph()
            }
        }
    }
}
