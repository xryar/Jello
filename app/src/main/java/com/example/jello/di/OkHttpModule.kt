package com.example.jello.di

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.example.jello.annotation.DefaultOkHttpInstance
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Cache
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class OkHttpModule {

    private val cacheSize = (10 * 1024 * 1024).toLong() // 10mb
    private val readTimeout = 180.toLong() // 3m
    private val connectTimeout = 180.toLong() // 3m

    @Singleton
    @Provides
    @DefaultOkHttpInstance
    fun providesDefaultOkHttpClient(
        @ApplicationContext context: Context,
    ) : OkHttpClient {
        return OkHttpClient.Builder().apply {
            cache(Cache(context.cacheDir, cacheSize))
            readTimeout(readTimeout, TimeUnit.SECONDS)
            connectTimeout(connectTimeout, TimeUnit.SECONDS)
            addInterceptor(ChuckerInterceptor.Builder(context).build())
        }.build()
    }

}