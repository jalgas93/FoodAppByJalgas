package com.example.foodappbyjalgas.iteractors

import com.example.foodappbyjalgas.cache.DaoDatabase
import com.example.foodappbyjalgas.cache.model.ModelDatabase
import com.example.foodappbyjalgas.cache.model.ModelDatabaseMapper
import com.example.foodappbyjalgas.domain.data.State
import com.example.foodappbyjalgas.domain.model.Model

import com.example.foodappbyjalgas.network.model.NetworkService
import com.example.foodappbyjalgas.network.model.RetrofitModelMapper
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


class MainRepository(
        private val retrofitService: NetworkService,
        private val retrofitMapper: RetrofitModelMapper,
        private val roomDao: DaoDatabase,
        private val roomMapper: ModelDatabaseMapper

) {
    fun execute(
            resipeId: Int,
            token: String
    ): Flow<State<Model>> = flow {

        try {

            emit(State.loading())
            delay(1000)

            var recipe = getRecipeFromCache(recipeId = resipeId)

            if (recipe != null) {
                emit(State.Success(recipe))
            } else {

                roomDao.insert(

                        roomMapper.mapFromDomainModel(
                                getRecipeFromNetwork(token, resipeId)
                        )

                )

                recipe = getRecipeFromCache(recipeId = resipeId)
                    if (recipe !=null) {
                        emit(State.Success(recipe))

                    } else{

                    }
            }


        } catch (e: Exception) {
            emit(State.Error<Model>(e.message?:"Unknown Error"))
        }

    }

    private suspend fun getRecipeFromNetwork(token: String,resipeId: Int): Model {
             return retrofitMapper.mapToDomainModel(retrofitService.get(token,resipeId))

    }

    private suspend fun getRecipeFromCache(recipeId: Int): Model {
        return roomDao.getRecipeById(recipeId).let { ModelDatabase ->
            roomMapper.mapToDomainModel(ModelDatabase)
        }


    }

}