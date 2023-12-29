package org.example.communicationktorservertest

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.core.App
import com.varabyte.kobweb.core.KobwebApp

@App
@Composable
fun MyApp(content: @Composable () -> Unit) {
    KobwebApp {
        content()
    }
}
