package com.example.foodappbyjalgas.di

import androidx.room.Room
import com.example.foodappbyjalgas.cache.DaoDatabase
import com.example.foodappbyjalgas.cache.database.AppDatabase
import com.example.foodappbyjalgas.network.model.RetrofitModelMapper
import com.example.foodappbyjalgas.util.App
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object CacheModule {
    @Singleton
    @Provides
    fun provideDB(app: App): AppDatabase {
        return Room
                .databaseBuilder(app, AppDatabase::class.java, AppDatabase.DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .build()
    }

    @Singleton
    @Provides
    fun provideDao(db: AppDatabase): DaoDatabase {
        return db.dao()
    }

    @Singleton
    @Provides
    fun provideDataBaseMapper(): RetrofitModelMapper {
        return RetrofitModelMapper()
    }
}