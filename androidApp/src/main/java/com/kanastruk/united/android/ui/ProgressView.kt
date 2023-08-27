package com.kanastruk.united.android.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ProgressView() {
    Column(Modifier.fillMaxWidth()) {
        CircularProgressIndicator(
            Modifier
                .size(32.dp)
                .align(Alignment.CenterHorizontally)
        )
    }
}