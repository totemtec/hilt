package com.demo.f

import android.app.Activity
import android.app.Application
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val application: Application,
) : ViewModel() {
    override fun toString(): String {
        return "application = $application"
    }
}