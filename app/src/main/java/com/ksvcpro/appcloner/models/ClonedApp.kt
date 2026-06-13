package com.ksvcpro.appcloner.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "cloned_apps")
data class ClonedApp(
    @PrimaryKey
    val cloneId: String = UUID.randomUUID().toString(),
    val originalPackageName: String,
    val cloneName: String,
    val createdAt: Long = System.currentTimeMillis(),
    val lastAccessedAt: Long = System.currentTimeMillis(),
    val isRunning: Boolean = false,
    val dataPath: String = "",
    val profileName: String = "",
    val permissionsGranted: String = "", // JSON string
    val fakeCamera: Boolean = true,
    val storage: Long = 0 // in bytes
)
