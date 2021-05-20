package com.demo.jiufengte.chapter04a

import javax.inject.Inject

class Dog @Inject constructor(@OldUser val owner: User) {
    lateinit var name: String
    override fun toString(): String {
        return "Dog: $name, Owner: ${owner.name} Owner Age: ${owner.age}"
    }
}