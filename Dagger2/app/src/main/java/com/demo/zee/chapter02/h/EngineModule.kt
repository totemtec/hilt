package com.demo.zee.chapter02.h

import dagger.Module
import dagger.Provides
import javax.inject.Inject
import javax.inject.Named

interface Engine {
}

class ChinaEngine @Inject constructor():Engine {
}

class UsaEngine @Inject constructor():Engine {
}

@Module
class EngineModule {
    @Provides
    @MadeInChina
    fun provideChinaEngine(): Engine {
        return ChinaEngine()
    }

    @Provides
    @MadeInUSA
    fun provideUsaEngine(): Engine {
        return UsaEngine()
    }

    @Provides
    @Named("chinaEngine")
    fun provideChinaEngineWithNamed(): Engine {
        return ChinaEngine()
    }
}