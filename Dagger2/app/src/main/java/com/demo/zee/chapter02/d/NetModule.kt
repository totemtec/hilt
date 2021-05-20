package com.demo.zee.chapter02.d

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit

@Module
class NetModule {

    @MyScope
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl("https://www.google.com")
            .build()
    }

    @MyScope
    @Provides
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @MyScope
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient()
    }
}