package com.ksvcpro.appcloner.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.ksvcpro.appcloner.database.AppDatabase
import com.ksvcpro.appcloner.models.AppPermission
import com.ksvcpro.appcloner.repository.AppRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class PermissionViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: AppRepository
    val allPermissions: Flow<List<AppPermission>>

    init {
        val database = AppDatabase.getDatabase(application)
        repository = AppRepository(database)
        allPermissions = repository.getAllPermissions()
    }

    fun insertPermission(permission: AppPermission) = viewModelScope.launch {
        repository.insertPermission(permission)
    }

    fun updatePermission(permission: AppPermission) = viewModelScope.launch {
        repository.updatePermission(permission)
    }

    fun deletePermission(permission: AppPermission) = viewModelScope.launch {
        repository.deletePermission(permission)
    }

    fun getPermissionsByCloneId(cloneId: String): Flow<List<AppPermission>> {
        return repository.getPermissionsByCloneId(cloneId)
    }

    fun deletePermissionsByCloneId(cloneId: String) = viewModelScope.launch {
        repository.deletePermissionsByCloneId(cloneId)
    }
}
