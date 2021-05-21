package com.demo.g

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.demo.R
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ActivityBinds : AppCompatActivity() {

    @Inject
    lateinit var chinaCar: ChinaCar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hilt)

        val infoView: TextView = findViewById(R.id.info_view)


        chinaCar.name="比亚迪"
        chinaCar.engine.on()
        chinaCar.engine.off()

        infoView.text = chinaCar.toString()
    }

}