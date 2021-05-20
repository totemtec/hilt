package com.demo.zee.chapter02.f

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.demo.R
import retrofit2.Retrofit
import javax.inject.Inject


/**
 * 组件依赖
 */
class ActivitySubcomponent : AppCompatActivity() {

    @Inject
    lateinit var user: User
    @Inject
    lateinit var user2: User

    @Inject
    lateinit var apiService: ApiService

    @Inject
    lateinit var apiService2: ApiService

    @Inject
    lateinit var retrofit: Retrofit

    @Inject
    lateinit var context: Context

    lateinit var userComponent: UserComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dagger)


        userComponent = DaggerUserComponent.builder().applicationComponent(MyApplication.component).build()

        userComponent.inject(this)

        val infoView: TextView = findViewById(R.id.info_view)
        infoView.text = "$user, $user2 \n $retrofit \n $apiService \n $apiService2 \n $context"

        val infoButton: Button = findViewById(R.id.info_button)
        infoButton.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }
    }
}