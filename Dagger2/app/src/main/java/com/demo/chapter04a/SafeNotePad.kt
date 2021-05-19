package com.demo.chapter04a

import javax.inject.Inject

data class SafeNotePad @Inject constructor(val name:String,
                                           val content:String,
                                           val author:String)