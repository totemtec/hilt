package com.demo.zee.chapter02.g

import javax.inject.Inject

class Car @Inject constructor(val engine: Engine) {
    override fun toString(): String {
        return "Car with Engine: $engine"
    }
}
