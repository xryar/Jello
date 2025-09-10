package com.example.jello.di

import com.example.domain.repository.JelloRepository
import com.example.domain.repository.PreferenceRepository
import com.example.local.preference.SharedPreference
import com.example.local.repository.PreferenceRepositoryImpl
import com.example.remote.repository.JelloRepositoryImpl
import com.example.remote.service.JelloService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    fun providesJelloRepository(jelloService: JelloService) : JelloRepository {
        return JelloRepositoryImpl(jelloService)
    }

    @Provides
    @Singleton
    fun providesPreferenceRepository(sharedPreference: SharedPreference) : PreferenceRepository {
        return PreferenceRepositoryImpl(sharedPreference)
    }
}