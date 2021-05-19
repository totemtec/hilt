package com.demo.chapter04a

import dagger.Module
import dagger.Provides

@Module
class UserModule
{
//    @Reusable
    @Provides
    fun provideSafeNotepad()=SafeNotePad("安全手册", "不能喝酒", "朝阳分局")

    @Provides
    fun provideUserCommon(car:Car, pad:SafeNotePad):User{
        return User(18, car, pad)
    }

    @Provides
    @YoungUser
    fun provideUserYoung(car:Car, pad:SafeNotePad):User{
        return  User(28, car, pad)
    }

    @Provides
    @OldUser
    fun provideUserOld(car:Car, pad:SafeNotePad):User{
        return User(38, car, pad)
    }
}