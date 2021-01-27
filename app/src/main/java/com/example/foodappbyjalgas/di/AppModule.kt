package com.example.foodappbyjalgas.di

import android.content.Context
import com.example.foodappbyjalgas.util.App
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module

object AppModule {
    @Singleton
    @Provides
    fun providesApplicatioin(@ApplicationContext app: Context): App {
        return app as App

    }
}