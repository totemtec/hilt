package com.demo.chapter04

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class YoungUser

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class OldUser