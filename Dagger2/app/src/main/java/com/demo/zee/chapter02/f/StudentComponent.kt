package com.demo.zee.chapter02.f

import dagger.Subcomponent

@Subcomponent(modules = [StudentModule::class])
interface StudentComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): StudentComponent
    }

    fun inject(activity: SecondActivity)
}