package com.demo.zee.chapter02.d

import javax.inject.Inject

class User @Inject constructor() {
    val name = "User from @Inject constructor()"
}