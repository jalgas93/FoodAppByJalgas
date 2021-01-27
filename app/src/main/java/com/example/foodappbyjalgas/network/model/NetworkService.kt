package com.example.foodappbyjalgas.network.model

import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface NetworkService {


    @GET("get")
    suspend fun get(
            @Header("Authorization") token: String,
            @Query("id") id: Int
    )
}