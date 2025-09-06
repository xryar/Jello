package com.example.jello.navigator

import com.example.navigator.Navigator

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNavigator() : Navigator = AppNavigator()

}