package com.demo.b

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.demo.R
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ActivityBinds : AppCompatActivity() {

    @Inject
    lateinit var chinaCar:ChinaCar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_binds)

        val infoView: TextView = findViewById(R.id.info_view)
        val infoButton: Button = findViewById(R.id.info_button)


        infoButton.setOnClickListener {
            chinaCar.name="比亚迪"
            chinaCar.engine.on()
            chinaCar.engine.off()

            infoView.text = chinaCar.toString()
        }
    }

}