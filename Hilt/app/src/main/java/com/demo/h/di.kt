package com.demo.h

import android.util.Log
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import javax.inject.Inject

interface Engine{
    fun on()
    fun off()
}

class ChinaEngine @Inject constructor():Engine{
    override fun on() {
        Log.i("zrm", "ChinaEngine on")
    }
    override fun off() {
        Log.i("zrm", "ChinaEngine off")
    }
}

class AmericaEngine @Inject constructor():Engine{
    override fun on() {
        Log.i("zrm", "AmericaEngine on")
    }
    override fun off() {
        Log.i("zrm", "AmericaEngine off")
    }
}

class ChinaCar @Inject constructor(val engine:Engine){
    lateinit var name:String
    override fun toString(): String {
        return "ChinaCar: $name  Engine: $engine"
    }
}


@Module
@InstallIn(ActivityComponent::class)
class MainModule {
    @Provides
    @MadeInCN
    fun provideChinaCar():ChinaCar
    {
        return ChinaCar(ChinaEngine())
    }

    @Provides
    @MadeInUSA
    fun provideChinaCar2():ChinaCar
    {
        return ChinaCar(AmericaEngine())
    }
}