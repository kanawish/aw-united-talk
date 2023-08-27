package com.kanastruk.united.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import com.kanastruk.sandbox.FooModel
import com.kanastruk.united.android.ui.theme.CustomTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class MainActivity : ComponentActivity() {
    private val app by lazy { (application as App) }
    // I'm thinking even a template project needs something like Koin or Dagger setup.
    private val fooModel = FooModel()

    // Mostly for debugging.
    private val scope = CoroutineScope(SupervisorJob())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // NOTE: Debug info
        setContent {
            CustomTheme {
                Scaffold { padding ->
                    Surface(Modifier.padding(padding)) {
                        Column(Modifier.fillMaxWidth()) {
                            Text(fooModel.salutation("MainActivity"))
                        }
                    }
                }
            }
        }
    }

}
