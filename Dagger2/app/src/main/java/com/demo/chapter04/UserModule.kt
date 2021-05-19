package com.demo.chapter04

import dagger.Module
import dagger.Provides

import javax.inject.Named

@Module
class UserModule
{
    @Provides
    fun provideUserCommon():User{
        return User(18)
    }

    @Provides
    @YoungUser
    fun provideUserYoung():User{
        return  User(28)
    }

    @Provides
    @OldUser
    fun provideUserOld():User{
        return User(38)
    }

}