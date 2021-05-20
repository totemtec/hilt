package com.demo.jiufengte.chapter04a

import android.util.Log
import javax.inject.Inject

class User @Inject constructor(val age: Int, val car:Car, val pad:SafeNotePad)
{
    lateinit var name:String
    fun gotoCompany()
    {
        car.engine.on()
        Log.i("zrm", "$name goto company")
        car.engine.off()
    }
    override fun toString(): String {
        return "User Name:$name, Age:$age, Car:${car.name}, $pad"
    }
}