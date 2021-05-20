package com.demo.zee.chapter02.b

import dagger.Component
import javax.inject.Singleton

// 2. 将模块装载到组件
@Component(modules = [NetModule::class])
interface ApplicationComponent {
    fun inject(activity: ActivityModule)
}
