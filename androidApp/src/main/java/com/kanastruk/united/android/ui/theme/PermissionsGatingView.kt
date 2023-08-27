package com.kanastruk.united.android.ui.theme

import android.Manifest
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.content.edit
import appSharedPrefs
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberMultiplePermissionsState
import com.kanastruk.united.android.ui.navigateToAppSettings

private const val SHOULD_OPEN_SETTINGS = "SHOULD_OPEN_SETTINGS"

@Composable
@OptIn(ExperimentalPermissionsApi::class)
fun PermissionsGatingView(block: @Composable ()->Unit) {
    val permissions = rememberMultiplePermissionsState(
        listOf(
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.CAMERA,
            Manifest.permission.RECORD_AUDIO,
            Manifest.permission.READ_PHONE_STATE,
        )
    )

    var isRationaleShown by remember { mutableStateOf(false) }

    val context = LocalContext.current
    val prefs = context.appSharedPrefs()

    if(isRationaleShown) {
        AlertDialog(
            text = { Text("Please grant the follow permission requests.") },
            onDismissRequest = { isRationaleShown = false },
            confirmButton = {
                TextButton(onClick = {
                    if (!permissions.shouldShowRationale && prefs.getBoolean(SHOULD_OPEN_SETTINGS, false)) {
                        context.navigateToAppSettings()
                    } else {
                        permissions.launchMultiplePermissionRequest()
                        prefs.edit(commit = true) { putBoolean(SHOULD_OPEN_SETTINGS, true) }
                    }
                    isRationaleShown = false
                }) {
                    Text("Start permission requests")
                }
            }
        )

    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        if (permissions.allPermissionsGranted) {
            prefs.edit(commit = true) { putBoolean(SHOULD_OPEN_SETTINGS, false) }
            block()
        } else {
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = { isRationaleShown = true }
            ) {
                Text("Grant missing permissions")
            }
        }
    }

}