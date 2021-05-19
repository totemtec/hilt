package com.demo.chapter04a

import dagger.Binds
import dagger.Module

@Module
interface EngineModule {
    @Binds
    fun  bindEngine(impl: ChinaEngine):Engine
}