package com.demo.zee

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.demo.databinding.ActivityZeeBinding
import com.demo.zee.chapter01.ManualActivity
import com.demo.zee.chapter02.a.ActivityA
import com.demo.zee.chapter02.b.ActivityModule
import com.demo.zee.chapter02.c.ActivitySingleton
import com.demo.zee.chapter02.d.ActivityScope
import com.demo.zee.chapter02.e.ActivityDependency
import com.demo.zee.chapter02.f.ActivitySubcomponent
import com.demo.zee.chapter02.g.ActivityBinds
import com.demo.zee.chapter02.h.ActivityQualifier


class ZeeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityZeeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityZeeBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    fun chapter01(v: View) {
        val intent = Intent(this, ManualActivity::class.java)
        startActivity(intent)
    }

    fun chapter02a(v: View) {
        val intent = Intent(this, ActivityA::class.java)
        startActivity(intent)
    }

    fun chapter02b(v: View) {
        val intent = Intent(this, ActivityModule::class.java)
        startActivity(intent)
    }

    fun chapter02c(v: View) {
        val intent = Intent(this, ActivitySingleton::class.java)
        startActivity(intent)
    }

    fun chapter02d(v: View) {
        val intent = Intent(this, ActivityScope::class.java)
        startActivity(intent)
    }

    fun chapter02e(v: View) {
        val intent = Intent(this, ActivityDependency::class.java)
        startActivity(intent)
    }

    fun chapter02f(v: View) {
        val intent = Intent(this, ActivitySubcomponent::class.java)
        startActivity(intent)
    }

    fun chapter02g(v: View) {
        val intent = Intent(this, ActivityBinds::class.java)
        startActivity(intent)
    }

    fun chapter02h(v: View) {
        val intent = Intent(this, ActivityQualifier::class.java)
        startActivity(intent)
    }
}

