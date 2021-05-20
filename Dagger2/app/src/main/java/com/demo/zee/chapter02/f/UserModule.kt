package com.demo.zee.chapter02.f

import dagger.Module
import dagger.Provides

@Module
class UserModule {

    @UserScope
    @Provides
    fun provideUser(): User {
        return User()
    }
}