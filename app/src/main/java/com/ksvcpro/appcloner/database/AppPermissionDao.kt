package com.ksvcpro.appcloner.database

import androidx.room.*
import com.ksvcpro.appcloner.models.AppPermission
import kotlinx.coroutines.flow.Flow

@Dao
interface AppPermissionDao {
    @Insert
    suspend fun insertPermission(permission: AppPermission)

    @Update
    suspend fun updatePermission(permission: AppPermission)

    @Delete
    suspend fun deletePermission(permission: AppPermission)

    @Query("SELECT * FROM app_permissions WHERE cloneId = :cloneId")
    fun getPermissionsByCloneId(cloneId: String): Flow<List<AppPermission>>

    @Query("SELECT * FROM app_permissions WHERE cloneId = :cloneId AND permission = :permission")
    suspend fun getPermission(cloneId: String, permission: String): AppPermission?

    @Query("DELETE FROM app_permissions WHERE cloneId = :cloneId")
    suspend fun deletePermissionsByCloneId(cloneId: String)

    @Query("SELECT * FROM app_permissions")
    fun getAllPermissions(): Flow<List<AppPermission>>
}
