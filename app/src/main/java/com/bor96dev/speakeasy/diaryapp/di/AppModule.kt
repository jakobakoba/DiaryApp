package com.bor96dev.speakeasy.diaryapp.di

import android.content.Context
import com.bor96dev.speakeasy.diaryapp.data.EventRepository
import com.bor96dev.speakeasy.diaryapp.data.EventRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideEventRepository(@ApplicationContext context: Context) : EventRepository = EventRepositoryImpl(context)

    @Provides
    @Singleton
    fun provideApplicationContext(@ApplicationContext app: Context) : Context = app

}