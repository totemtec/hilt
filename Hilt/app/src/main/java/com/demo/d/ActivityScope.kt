package com.demo.d

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.demo.R
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ActivityScope : AppCompatActivity() {

    @Inject
    lateinit var user: User

    @Inject
    lateinit var user2: User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hilt)

        val infoView: TextView = findViewById(R.id.info_view)

        infoView.text = "user = $user \n" +
                "user2 = $user2"

        val infoButton: Button = findViewById(R.id.info_button)
        infoButton.text = "Show Second Activity"
        infoButton.setOnClickListener {
            startActivity(Intent(this, ActivitySecond::class.java))
        }
    }
}