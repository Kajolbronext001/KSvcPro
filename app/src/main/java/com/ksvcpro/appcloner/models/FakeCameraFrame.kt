package com.ksvcpro.appcloner.models

import android.graphics.Bitmap

data class FakeCameraFrame(
    val bitmap: Bitmap,
    val timestamp: Long = System.currentTimeMillis(),
    val width: Int = bitmap.width,
    val height: Int = bitmap.height
)
