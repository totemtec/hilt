package com.demo.a

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.demo.R
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ActivityInject : AppCompatActivity() {

    @Inject
    lateinit var user:User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inject)

        val infoView: TextView = findViewById(R.id.info_view)
        val infoButton: Button = findViewById(R.id.info_button)
        infoButton.setOnClickListener {
            user.name = "张三"
            user.age = 30
            infoView.text = user.toString()
        }
    }

}