package com.demo

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.demo.chapter01.Activity01
import com.demo.chapter02.Activity02
import com.demo.chapter03.Activity03
import com.demo.chapter04.Activity04
import com.demo.chapter04a.Activity04a
import com.demo.chapter05.a.Activity05a
import com.demo.chapter05.b.Activity05b
import com.demo.chapter05.c.Activity05c
import com.demo.chapter05.d.LazyActivity
import com.demo.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    fun chapter01(v: View) {
        val intent = Intent(this, Activity01::class.java)
        startActivity(intent)
    }

    fun chapter02(v: View) {
        val intent = Intent(this, Activity02::class.java)
        startActivity(intent)
    }

    fun chapter03(v: View) {
        val intent = Intent(this, Activity03::class.java)
        startActivity(intent)
    }

    fun chapter04(v: View) {
        val intent = Intent(this, Activity04::class.java)
        startActivity(intent)
    }

    fun chapter04a(v: View) {
        val intent = Intent(this, Activity04a::class.java)
        startActivity(intent)
    }

    fun chapter05a(v: View) {
        val intent = Intent(this, Activity05a::class.java)
        startActivity(intent)
    }

    fun chapter05b(v: View) {
        val intent = Intent(this, Activity05b::class.java)
        startActivity(intent)
    }

    fun chapter05c(v: View) {
        val intent = Intent(this, Activity05c::class.java)
        startActivity(intent)
    }

    fun chapter05d(v: View) {
        val intent = Intent(this, LazyActivity::class.java)
        startActivity(intent)
    }



//    fun chapter06(v: View) {
//        val intent = Intent(this, Activity06::class.java)
//        startActivity(intent)
//    }


}

