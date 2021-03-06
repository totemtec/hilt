package com.demo.d

import android.app.Activity
import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(ActivityComponent::class)
//@InstallIn(SingletonComponent::class)  //这里ApplicationComponent已经替换为SingletonComponent
class AppModule {

    @ActivityScoped
//    @Singleton
    @Provides
    fun provideUser(): User {
        return User()
    }

    //application 和 activity 是hilt默认提供的默认绑定
    // 这里只能使用 ActivityComponent  @ActivityScoped。 SingletonComponent不能提供activity的实例
    @ActivityScoped
//    @Singleton
    @Provides
    fun provideViewModel(
        user: User,
        application: Application,
        activity: Activity,
    ): ViewModel {
        return ViewModel(user, application, activity)
    }
}