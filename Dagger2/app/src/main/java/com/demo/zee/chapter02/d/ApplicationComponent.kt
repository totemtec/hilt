package com.demo.zee.chapter02.d

import dagger.Component
import javax.inject.Singleton

@MyScope
@Component(modules = [NetModule::class])
interface ApplicationComponent {
    fun inject(activity: ActivityScope)

    fun inject(activity: SecondActivity)
}