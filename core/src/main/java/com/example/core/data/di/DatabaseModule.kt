package com.example.core.data.di

import android.content.Context
import androidx.room.Room
import com.example.core.data.source.local.room.MoviesDao
import com.example.core.data.source.local.room.MoviesDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): MoviesDatabase = Room.databaseBuilder(
        context,
        MoviesDatabase::class.java, "Movies.db"
    ).fallbackToDestructiveMigration().build()

    @Provides
    fun provideTourismDao(database: MoviesDatabase): MoviesDao = database.moviesDao()
}