package com.demo.jiufengte.chapter04

import javax.inject.Inject

class User @Inject constructor(val age: Int) {
    var name: String? = null
    override fun toString(): String {
        return "Name: $name , Age: $age"
    }
}