package com.example.jello.di

import com.example.jello.annotation.JelloRetrofitInstance
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
class ApiServiceModule {

    @Provides
    fun providesJelloService(@JelloRetrofitInstance retrofit: Retrofit) =
        retrofit.create(JelloService::class.java)
}