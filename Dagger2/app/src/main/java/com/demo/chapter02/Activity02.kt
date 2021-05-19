package com.demo.chapter02

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.demo.R
import dagger.Component
import javax.inject.Inject

class Dog @Inject constructor(val owner: User) {
    lateinit var name: String
    override fun toString(): String {
        return "Dog: $name, Owner: ${owner.name}"
    }
}

class User @Inject constructor() {
    var name: String? = null
    override fun toString(): String {
        return "Name: $name"
    }
}

@Component
public interface Component02 {
    fun inject(activity: Activity02)
}

class Activity02 : AppCompatActivity() {

    @Inject
    lateinit var user: User

    @Inject
    lateinit var dog: Dog

    private lateinit var buttonDog: Button
    private lateinit var buttonUser: Button
    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_02)
        buttonDog = findViewById(R.id.button_computer)
        buttonUser = findViewById(R.id.button_printer)
        textView = findViewById(R.id.text_view)


        DaggerComponent02.builder().build().inject(this)

        user.name="Hero"
        dog.name="大黄"
        dog.owner.name="小明"

        buttonUser.setOnClickListener {
            textView.text = user.toString()
        }
        buttonDog.setOnClickListener {
            textView.text = dog.toString()
        }
    }
}