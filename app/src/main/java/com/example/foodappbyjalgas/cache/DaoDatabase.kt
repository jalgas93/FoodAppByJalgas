package com.example.foodappbyjalgas.cache

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.foodappbyjalgas.cache.model.ModelDatabase

@Dao
interface DaoDatabase {

    @Insert
    suspend fun insert(modelDatabase: ModelDatabase):Long

    @Query("SELECT * FROM databaseJalgas WHERE id = :id")
    suspend fun getRecipeById(id:Int):ModelDatabase

}