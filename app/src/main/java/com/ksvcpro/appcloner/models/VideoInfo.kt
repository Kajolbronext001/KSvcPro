package com.ksvcpro.appcloner.models

import android.net.Uri

data class VideoInfo(
    val uri: Uri,
    val title: String,
    val duration: Long = 0,
    val size: Long = 0,
    val path: String = ""
)
