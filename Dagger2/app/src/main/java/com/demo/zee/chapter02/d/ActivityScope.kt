package com.demo.zee.chapter02.d

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.demo.R
import retrofit2.Retrofit
import javax.inject.Inject




/**
 * 使用作用域实现单例
 */

class ActivityScope : AppCompatActivity() {

    @Inject
    lateinit var user: User
    @Inject
    lateinit var user2: User

    @Inject
    lateinit var apiService: ApiService

    @Inject
    lateinit var apiService2: ApiService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dagger)

//        DaggerApplicationComponent.create().inject(this)

        MyApplication.component.inject(this)

        val infoView: TextView = findViewById(R.id.info_view)
        infoView.text = "$user, $user2 \n" +
                    "$apiService, $apiService2"

        val infoButton: Button = findViewById(R.id.info_button)
        infoButton.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }
    }
}