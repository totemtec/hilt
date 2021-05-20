package com.demo.zee.chapter02.f

import android.content.Context
import dagger.Component
import retrofit2.Retrofit

@MyScope
@Component(modules = [NetModule::class, SubComponentModule::class])
interface ApplicationComponent {

//    fun inject(activity: MainActivity)

//    fun inject(activity: SecondActivity)

    fun retrofit(): Retrofit

    fun apiService(): ApiService

    fun context(): Context

    fun studentComponentFactory(): StudentComponent.Factory
}