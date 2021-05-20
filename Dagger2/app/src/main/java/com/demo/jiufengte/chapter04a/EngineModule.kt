package com.demo.jiufengte.chapter04a

import dagger.Binds
import dagger.Module

@Module
interface EngineModule {
    @Binds
    fun  bindEngine(impl: ChinaEngine):Engine
}