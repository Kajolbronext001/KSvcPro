package com.ksvcpro.appcloner.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.ksvcpro.appcloner.database.AppDatabase
import com.ksvcpro.appcloner.models.ClonedApp
import com.ksvcpro.appcloner.repository.AppRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class CloneViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: AppRepository
    val allClonedApps: Flow<List<ClonedApp>>

    init {
        val database = AppDatabase.getDatabase(application)
        repository = AppRepository(database)
        allClonedApps = repository.getAllClonedApps()
    }

    fun insertClonedApp(clonedApp: ClonedApp) = viewModelScope.launch {
        repository.insertClonedApp(clonedApp)
    }

    fun updateClonedApp(clonedApp: ClonedApp) = viewModelScope.launch {
        repository.updateClonedApp(clonedApp)
    }

    fun deleteClonedApp(clonedApp: ClonedApp) = viewModelScope.launch {
        repository.deleteClonedApp(clonedApp)
    }

    fun deleteClonedAppById(cloneId: String) = viewModelScope.launch {
        repository.deleteClonedAppById(cloneId)
    }

    fun getClonedAppsByPackage(packageName: String): Flow<List<ClonedApp>> {
        return repository.getClonedAppsByPackage(packageName)
    }

    fun getTotalClonedApps(): Flow<Int> {
        return repository.getTotalClonedApps()
    }
}
