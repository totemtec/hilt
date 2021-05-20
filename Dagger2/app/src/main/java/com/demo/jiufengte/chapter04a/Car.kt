package com.demo.jiufengte.chapter04a

import android.util.Log
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

class Car @Inject constructor(val engine: Engine){
    lateinit var name:String
}