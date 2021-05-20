package com.demo.zee.chapter02.f

import dagger.Component

@UserScope
@Component(modules = [ UserModule::class ], dependencies = [ ApplicationComponent::class ])
interface UserComponent {
    fun inject(activity: ActivitySubcomponent)
}