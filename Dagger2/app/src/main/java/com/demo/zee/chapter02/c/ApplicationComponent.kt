package com.demo.zee.chapter02.c

import dagger.Component
import javax.inject.Singleton

// 对象实例与其组件的生命周期一致，所以需要这里也注解@Singleton
@Singleton
@Component(modules = [NetModule::class])
interface ApplicationComponent {
    fun inject(activity: ActivitySingleton)

    fun inject(activity: SecondActivity)
}