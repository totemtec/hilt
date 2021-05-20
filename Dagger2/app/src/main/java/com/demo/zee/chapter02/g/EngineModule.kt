package com.demo.zee.chapter02.g

import dagger.Binds
import dagger.Module
import javax.inject.Inject

interface Engine {
}

class ChinaEngine @Inject constructor():Engine {
}

class UsaEngine @Inject constructor():Engine {
}

@Module
interface EngineModule {
    @Binds
    fun bindEngine(impl: ChinaEngine):Engine
}