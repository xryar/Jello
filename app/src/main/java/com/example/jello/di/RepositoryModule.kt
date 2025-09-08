package com.example.jello.di

import com.example.domain.repository.JelloRepository
import com.example.remote.repository.JelloRepositoryImpl
import com.example.remote.service.JelloService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    fun providesJelloRepository(jelloService: JelloService) : JelloRepository {
        return JelloRepositoryImpl(jelloService)
    }
}