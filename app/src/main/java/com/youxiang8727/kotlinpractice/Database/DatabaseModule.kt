package com.youxiang8727.kotlinpractice.Database

import android.content.Context
import android.provider.ContactsContract
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideWordDao(database: Database): WordDao{
        return database.wordDao()
    }

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context):
        Database{
            return Room.databaseBuilder(
                context,
                Database::class.java,
            "database").build()
        }
}