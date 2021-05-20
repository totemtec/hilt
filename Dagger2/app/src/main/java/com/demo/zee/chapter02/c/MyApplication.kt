package com.demo.zee.chapter02.c

import android.app.Application

class MyApplication: Application() {
    companion object {
        val component: ApplicationComponent = DaggerApplicationComponent.create()
    }
}