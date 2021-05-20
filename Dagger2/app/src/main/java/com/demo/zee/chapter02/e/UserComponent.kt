package com.demo.zee.chapter02.e

import dagger.Component

@UserScope
@Component(modules = [ UserModule::class ], dependencies = [ ApplicationComponent::class ])
interface UserComponent {
    fun inject(activity: ActivityDependency)
}