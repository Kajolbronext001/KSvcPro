package com.ksvcpro.appcloner.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "app_permissions")
data class AppPermission(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val cloneId: String,
    val permission: String,
    val isGranted: Boolean = false,
    val grantedAt: Long = System.currentTimeMillis()
)
