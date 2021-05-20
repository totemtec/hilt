package com.demo.zee.chapter02.c

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.demo.R
import javax.inject.Inject


class SecondActivity : AppCompatActivity() {

    @Inject
    lateinit var apiService3: ApiService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dagger)

//        DaggerApplicationComponent.create().inject(this)

        MyApplication.component.inject(this)
        val infoView: TextView = findViewById(R.id.info_view)
        infoView.text = "$apiService3"
    }
}