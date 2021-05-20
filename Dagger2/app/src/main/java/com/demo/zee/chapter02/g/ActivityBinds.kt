package com.demo.zee.chapter02.g

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.demo.R
import dagger.Component
import javax.inject.Inject


@Component(modules = [EngineModule::class])
interface BindsComponent {
    fun inject(activity: ActivityBinds)
}


class ActivityBinds : AppCompatActivity() {

    @Inject
    lateinit var car: Car

    @Inject
    lateinit var engine: Engine

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dagger)

        DaggerBindsComponent.create().inject(this)

        val infoView: TextView = findViewById(R.id.info_view)
        infoView.text = "$car \n $engine"
    }
}