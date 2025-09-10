package com.example.local.di

import android.content.Context
import com.example.local.preference.SharedPreference
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class PreferenceModule {

    @Provides
    @Singleton
    fun providePreference(
        @ApplicationContext context: Context
    ): SharedPreference {
        return SharedPreference(context)
    }

}