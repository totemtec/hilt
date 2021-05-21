package com.demo

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.demo.a.ActivityInject
import com.demo.b.ActivityModule
import com.demo.c.ActivityScope
import com.demo.d.ActivityDefaultBinding
import com.demo.e.ActivityPredefinedQualifiers
import com.demo.f.ActivityJetpack
import com.demo.g.ActivityBinds
import com.demo.h.ActivitySpecificBinding

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


    fun gotoDefaultBinding(v: View) {
        val intent = Intent(this, ActivityDefaultBinding::class.java)
        startActivity(intent)
    }

    fun gotoPredefinedQualifier(v: View) {
        val intent = Intent(this, ActivityPredefinedQualifiers::class.java)
        startActivity(intent)
    }

    fun gotoJetpackViewModel(v: View) {
        val intent = Intent(this, ActivityJetpack::class.java)
        startActivity(intent)
    }

    fun gotoBinds(v: View) {
        val intent = Intent(this, ActivityBinds::class.java)
        startActivity(intent)
    }

    fun gotoSpecificBinding(v: View) {
        val intent = Intent(this, ActivitySpecificBinding::class.java)
        startActivity(intent)
    }
}