package com.kanastruk.united.android.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun SimpleScaffoldBox(block: @Composable () -> Unit) {
    val fillMaxSize = Modifier.fillMaxSize()
    Scaffold { padding ->
        Surface(Modifier.padding(padding)) {
            Box(modifier = fillMaxSize, contentAlignment = Alignment.BottomCenter) {
                block()
            }
        }
    }
}