package com.demo.jiufengte.chapter04a

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class YoungUser

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class OldUser