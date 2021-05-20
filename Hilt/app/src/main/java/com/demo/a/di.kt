package com.demo.a

import javax.inject.Inject


class User @Inject constructor()
{
    var name:String=""
    var age = 0
    override fun toString()="User(name=$name age$age)"
}