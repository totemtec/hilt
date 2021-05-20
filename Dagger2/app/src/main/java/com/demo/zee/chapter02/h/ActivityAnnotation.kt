package com.demo.zee.chapter02.h

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.demo.R
import dagger.Component
import javax.inject.Inject
import javax.inject.Named


@Component(modules = [EngineModule::class])
interface AnnotationComponent {
    fun inject(activity: ActivityAnnotation)
}


class ActivityAnnotation : AppCompatActivity() {

    @Inject
    @MadeInUSA
    lateinit var engine: Engine

    @Inject
    @MadeInChina
    lateinit var engine2: Engine

    @Inject
    @Named("chinaEngine")
    lateinit var engine3: Engine

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dagger)

        DaggerAnnotationComponent.create().inject(this)

        val infoView: TextView = findViewById(R.id.info_view)
        infoView.text = "$engine \n $engine2 \n $engine3"
    }
}