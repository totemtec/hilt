package com.demo.zee.chapter02.e

import android.content.Context
import dagger.Component
import retrofit2.Retrofit

@MyScope
@Component(modules = [NetModule::class])
interface ApplicationComponent {

    fun retrofit(): Retrofit

    fun apiService(): ApiService

    fun context(): Context
}