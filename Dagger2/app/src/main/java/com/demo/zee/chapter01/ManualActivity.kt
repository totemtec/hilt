package com.demo.zee.chapter01

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.demo.R

class Engine {
    fun start() {
        Log.i("dagger2", "engine start")
    }
}

// 1. 构造函数注入
class Car constructor(val engine: Engine) {
    // 2. 字段注入 (Setter注入)
//    lateinit var engine: Engine

    fun start(): String {
        //0. 手动创建
//        engine = Engine()
        engine.start()
        return "car start"
    }
}

class ManualActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_00)

        val infoView: TextView = findViewById(R.id.info_view)
        infoView.text = Car(Engine()).start()
    }
}