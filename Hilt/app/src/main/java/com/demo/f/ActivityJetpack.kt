package com.demo.f

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
//import androidx.activity.viewModels
import com.demo.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ActivityJetpack : AppCompatActivity() {

//    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hilt)

        val infoView: TextView = findViewById(R.id.info_view)

//        infoView.text = "mainViewModel = $mainViewModel"
    }
}