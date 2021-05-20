package com.demo.zee.chapter02.f

import android.app.Application

class MyApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        component = DaggerApplicationComponent.builder().netModule(NetModule(this)).build()
    }

    companion object {
        lateinit var component: ApplicationComponent
    }
}