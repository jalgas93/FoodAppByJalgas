package com.example.foodappbyjalgas.di

import com.example.foodappbyjalgas.cache.DaoDatabase
import com.example.foodappbyjalgas.cache.model.ModelDatabaseMapper
import com.example.foodappbyjalgas.iteractors.GetRecipe
import com.example.foodappbyjalgas.network.model.NetworkService
import com.example.foodappbyjalgas.network.model.RetrofitModelMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object IteractorsModule {
    @Singleton
    @Provides
    fun providesGetRecipe(
            retrofitService: NetworkService,
            retrofiMapper: RetrofitModelMapper,
            roomDao: DaoDatabase,
            roomMapper: ModelDatabaseMapper
    ): GetRecipe {
        return GetRecipe(
                retrofitService = retrofitService,
                retrofitMapper = retrofiMapper,
                roomDao = roomDao,
                roomMapper = roomMapper
        )


    }
}