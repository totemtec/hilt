package com.demo.chapter04

import javax.inject.Inject
import javax.inject.Named

class Dog @Inject constructor(@OldUser val owner: User) {
    lateinit var name: String
    override fun toString(): String {
        return "Dog: $name, Owner: ${owner.name} Owner Age: ${owner.age}"
    }
}