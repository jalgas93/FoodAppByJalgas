package com.example.foodappbyjalgas.cache.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.foodappbyjalgas.cache.DaoDatabase
import com.example.foodappbyjalgas.cache.model.ModelDatabase

@Database(entities = [ModelDatabase::class],version = 1,exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun dao(): DaoDatabase

    companion object {
        val DATABASE_NAME: String = "database_db"
    }
}