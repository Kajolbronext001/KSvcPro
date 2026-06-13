package com.ksvcpro.appcloner.repository

import com.ksvcpro.appcloner.database.AppDatabase
import com.ksvcpro.appcloner.models.AppPermission
import com.ksvcpro.appcloner.models.ClonedApp
import kotlinx.coroutines.flow.Flow

class AppRepository(private val database: AppDatabase) {
    
    // ClonedApp Operations
    suspend fun insertClonedApp(clonedApp: ClonedApp) {
        database.clonedAppDao().insertClonedApp(clonedApp)
    }

    suspend fun updateClonedApp(clonedApp: ClonedApp) {
        database.clonedAppDao().updateClonedApp(clonedApp)
    }

    suspend fun deleteClonedApp(clonedApp: ClonedApp) {
        database.clonedAppDao().deleteClonedApp(clonedApp)
    }

    suspend fun getClonedAppById(cloneId: String): ClonedApp? {
        return database.clonedAppDao().getClonedAppById(cloneId)
    }

    fun getAllClonedApps(): Flow<List<ClonedApp>> {
        return database.clonedAppDao().getAllClonedApps()
    }

    fun getClonedAppsByPackage(packageName: String): Flow<List<ClonedApp>> {
        return database.clonedAppDao().getClonedAppsByPackage(packageName)
    }

    suspend fun deleteClonedAppById(cloneId: String) {
        database.clonedAppDao().deleteClonedAppById(cloneId)
    }

    fun getTotalClonedApps(): Flow<Int> {
        return database.clonedAppDao().getTotalClonedApps()
    }

    // AppPermission Operations
    suspend fun insertPermission(permission: AppPermission) {
        database.appPermissionDao().insertPermission(permission)
    }

    suspend fun updatePermission(permission: AppPermission) {
        database.appPermissionDao().updatePermission(permission)
    }

    suspend fun deletePermission(permission: AppPermission) {
        database.appPermissionDao().deletePermission(permission)
    }

    fun getPermissionsByCloneId(cloneId: String): Flow<List<AppPermission>> {
        return database.appPermissionDao().getPermissionsByCloneId(cloneId)
    }

    suspend fun getPermission(cloneId: String, permission: String): AppPermission? {
        return database.appPermissionDao().getPermission(cloneId, permission)
    }

    suspend fun deletePermissionsByCloneId(cloneId: String) {
        database.appPermissionDao().deletePermissionsByCloneId(cloneId)
    }

    fun getAllPermissions(): Flow<List<AppPermission>> {
        return database.appPermissionDao().getAllPermissions()
    }
}
