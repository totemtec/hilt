package com.demo.zee.chapter02.f

import dagger.Module
import dagger.Provides

@Module
class StudentModule {
    @Provides
    fun provideStudent(): Student {
        return Student()
    }
}