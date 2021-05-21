package com.demo.e

import android.app.Activity
import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ActivityScoped
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(ActivityComponent::class)
class AppModule {

    @ActivityScoped
    @Provides
    fun provideUser(): User {
        return User()
    }

    @Provides
    fun provideViewModel(
        user: User,
        application: Application,
        activity: Activity,
        @ApplicationContext context: Context, // 预定义限定符，@ApplicationContext 或 @ActivityContext
    ): ViewModel {
        return ViewModel(user, application, activity, context)
    }
}