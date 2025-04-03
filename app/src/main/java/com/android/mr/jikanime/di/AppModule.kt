package com.android.mr.jikanime.di

import com.android.mr.jikanime.data.AnimeRepository
import com.android.mr.jikanime.data.AnimeRepositoryImpl
import com.android.mr.jikanime.server.AnimeApiService
import com.android.mr.jikanime.server.RetrofitInstance
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideAnimeApi(): AnimeApiService = RetrofitInstance.api
}

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindAnimeRepository(repo: AnimeRepositoryImpl): AnimeRepository
}
