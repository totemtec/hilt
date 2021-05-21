package com.demo.b

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)  //这里ApplicationComponent已经替换为SingletonComponent
class AppModule {

    @Singleton
    @Provides
    fun provideUser(): User {
        return User()
    }
}