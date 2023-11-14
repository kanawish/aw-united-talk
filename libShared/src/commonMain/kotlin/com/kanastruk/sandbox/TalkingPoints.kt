package com.kanastruk.sandbox

import androidx.camera.core.ImageCapture
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

val imageCapture = ImageCapture.Builder()
    .setTargetRotation(view.display.rotation)
    .build()


