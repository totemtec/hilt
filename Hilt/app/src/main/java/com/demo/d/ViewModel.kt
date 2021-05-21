package com.demo.d

import android.app.Activity
import android.app.Application
import javax.inject.Inject

//class ViewModel @Inject constructor(
class ViewModel constructor(
    val user: User,
    private val application: Application,  // application 是hilt默认提供的默认绑定
    private val activity: Activity,  // activity 是hilt默认提供的默认绑定
) {

    override fun toString(): String {
        return "user = $user \n application = $application \n activity = $activity"
    }
}