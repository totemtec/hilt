package com.demo.zee

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.demo.databinding.ActivityZeeBinding
import com.demo.zee.chapter01.ManualActivity
import com.demo.zee.chapter02.a.ActivityA


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
}

