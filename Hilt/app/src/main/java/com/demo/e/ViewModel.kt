package com.demo.e

import android.app.Activity
import android.app.Application
import android.content.Context
import javax.inject.Inject

class ViewModel constructor(
    val user: User,
    private val application: Application,
    private val activity: Activity,
    private val context: Context,
) {

    override fun toString(): String {
        return "user = $user \n application = $application \n activity = $activity \n context = $context"
    }
}