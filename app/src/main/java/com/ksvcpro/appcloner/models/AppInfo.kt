package com.ksvcpro.appcloner.models

import android.graphics.drawable.Drawable

data class AppInfo(
    val packageName: String,
    val appName: String,
    val icon: Drawable? = null,
    val versionName: String = "1.0",
    val versionCode: Long = 0,
    val isSystem: Boolean = false,
    val isCloned: Boolean = false,
    val cloneId: String? = null
)
