package com.demo.zee.chapter02.b

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.demo.R
import retrofit2.Retrofit
import javax.inject.Inject



/**
 * 使用Module提供对象实例
 */

class ActivityModule : AppCompatActivity() {

    @Inject
    lateinit var retrofit: Retrofit

    @Inject
    lateinit var apiService: ApiService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dagger)

        DaggerApplicationComponent.create().inject(this)

        val infoView: TextView = findViewById(R.id.info_view)
        infoView.text = retrofit.baseUrl().toString() + " " + apiService.toString()
    }
}