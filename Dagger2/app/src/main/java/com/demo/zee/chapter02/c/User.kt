package com.demo.zee.chapter02.c

import javax.inject.Inject

class User @Inject constructor() {
    val name = "User from @Inject constructor()"
}