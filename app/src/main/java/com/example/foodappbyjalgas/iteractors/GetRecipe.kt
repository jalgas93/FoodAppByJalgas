package com.example.foodappbyjalgas.iteractors

import com.example.foodappbyjalgas.cache.DaoDatabase
import com.example.foodappbyjalgas.cache.model.ModelDatabaseMapper
import com.example.foodappbyjalgas.network.model.NetworkService
import com.example.foodappbyjalgas.network.model.RetrofitModelMapper

class GetRecipe(
        private val retrofitService:NetworkService,
        private val retrofitMapper:RetrofitModelMapper,
        private val roomDao:DaoDatabase,
        private val roomMapper:ModelDatabaseMapper

) {
}