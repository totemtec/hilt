package com.demo.zee.chapter02.f

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.demo.R
import javax.inject.Inject


class SecondActivity : AppCompatActivity() {

    @Inject
    lateinit var student: Student

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dagger)

//        DaggerApplicationComponent.create().inject(this)

        MyApplication.component.studentComponentFactory().create().inject(this)
        val infoView: TextView = findViewById(R.id.info_view)
        infoView.text = "$student"
    }
}