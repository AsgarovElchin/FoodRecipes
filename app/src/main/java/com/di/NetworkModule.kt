package com.di

import com.FoodRecipesApi
import com.elchinasgarov.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder().baseUrl(Constants.BASE_URL).client(OkHttpClient())
            .addConverterFactory(GsonConverterFactory.create()).build()


    @Singleton
    @Provides
    fun provideFoodRecipesApi(retrofit: Retrofit): FoodRecipesApi =
        retrofit.create(FoodRecipesApi::class.java)
}