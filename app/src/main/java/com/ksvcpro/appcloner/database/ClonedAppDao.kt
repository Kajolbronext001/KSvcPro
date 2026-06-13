package com.ksvcpro.appcloner.database

import androidx.room.*
import com.ksvcpro.appcloner.models.ClonedApp
import kotlinx.coroutines.flow.Flow

@Dao
interface ClonedAppDao {
    @Insert
    suspend fun insertClonedApp(clonedApp: ClonedApp)

    @Update
    suspend fun updateClonedApp(clonedApp: ClonedApp)

    @Delete
    suspend fun deleteClonedApp(clonedApp: ClonedApp)

    @Query("SELECT * FROM cloned_apps WHERE cloneId = :cloneId")
    suspend fun getClonedAppById(cloneId: String): ClonedApp?

    @Query("SELECT * FROM cloned_apps")
    fun getAllClonedApps(): Flow<List<ClonedApp>>

    @Query("SELECT * FROM cloned_apps WHERE originalPackageName = :packageName")
    fun getClonedAppsByPackage(packageName: String): Flow<List<ClonedApp>>

    @Query("DELETE FROM cloned_apps WHERE cloneId = :cloneId")
    suspend fun deleteClonedAppById(cloneId: String)

    @Query("SELECT COUNT(*) FROM cloned_apps")
    fun getTotalClonedApps(): Flow<Int>
}
