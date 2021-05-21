package com.demo

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.demo.a.ActivityInject
import com.demo.b.ActivityModule
import com.demo.c.ActivityScope

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun gotoInject(v: View) {
        val intent = Intent(this, ActivityInject::class.java)
        startActivity(intent)
    }

    fun gotoModule(v: View) {
        val intent = Intent(this, ActivityModule::class.java)
        startActivity(intent)
    }

    fun gotoScoped(v: View) {
        val intent = Intent(this, ActivityScope::class.java)
        startActivity(intent)
    }

}