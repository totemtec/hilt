package com.demo.h

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.demo.R
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ActivitySpecificBinding : AppCompatActivity() {

    @Inject @MadeInCN lateinit var chinaCar:ChinaCar
    @Inject @MadeInUSA lateinit var chinaCar2:ChinaCar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hilt)

        val infoView: TextView = findViewById(R.id.info_view)
        val infoButton: Button = findViewById(R.id.info_button)


        infoButton.setOnClickListener {

            chinaCar.name="比亚迪"
            chinaCar.engine.on()
            chinaCar.engine.off()

            chinaCar2.name="大众"
            chinaCar2.engine.on()
            chinaCar2.engine.off()

            infoView.text = chinaCar2.toString()

        }
    }

}