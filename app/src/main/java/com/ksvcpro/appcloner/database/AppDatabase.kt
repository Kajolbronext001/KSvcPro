package com.ksvcpro.appcloner.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ksvcpro.appcloner.models.AppPermission
import com.ksvcpro.appcloner.models.ClonedApp

@Database(entities = [ClonedApp::class, AppPermission::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun clonedAppDao(): ClonedAppDao
    abstract fun appPermissionDao(): AppPermissionDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "ksvcpro_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
