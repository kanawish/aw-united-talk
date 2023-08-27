package com.kanastruk.united.android.ui

import android.Manifest
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.preference.PreferenceManager
import android.provider.Settings
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.content.edit
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberMultiplePermissionsState

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun PermissionsGatedUI(content: @Composable () -> Unit) {
    val permissions = rememberMultiplePermissionsState(
        listOf(
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.CAMERA,
            Manifest.permission.READ_PHONE_STATE
        )
    )

    val context = LocalContext.current
    val preferences = PreferenceManager.getDefaultSharedPreferences(context)

    var isRationaleVisible by remember { mutableStateOf(false) }
    if (isRationaleVisible) {
        AlertDialog(
            text = { Text("Please grant missing permissions") },
            onDismissRequest = { isRationaleVisible = false },
            confirmButton = {
                TextButton(onClick = {
                    if (!permissions.shouldShowRationale && preferences.getBoolean("should_open_app_settings", false)) {
                        context.navigateToAppSettings()
                    } else {
                        permissions.launchMultiplePermissionRequest()
                        preferences.edit { putBoolean("should_open_app_settings", true) }
                    }
                    isRationaleVisible = false
                }) {
                    Text("Grant permissions")
                }
            }
        )
    }

    when {
        // If we got permissions, show the UI
        permissions.allPermissionsGranted -> {
            preferences.edit { putBoolean("should_open_app_settings", false) }
            content()
        }
        // Otherwise show permissions button.
        else -> {
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 28.dp, bottom = 3.dp),
                onClick = { isRationaleVisible = true }
            ) {
                Text(
                    text = "Grant missing permissions",
                    style = MaterialTheme.typography.titleSmall
                )
            }
        }
    }
}

fun Context.navigateToAppSettings() {
    val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS).apply {
        data = Uri.fromParts("package", packageName, null)
        addCategory(Intent.CATEGORY_DEFAULT)
        addFlags(
            Intent.FLAG_ACTIVITY_NEW_TASK or
                    Intent.FLAG_ACTIVITY_NO_HISTORY or
                    Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS
        )
    }
    startActivity(intent)
}
