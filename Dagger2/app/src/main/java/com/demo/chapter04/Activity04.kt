package com.demo.chapter04

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.demo.R
import com.demo.databinding.Activity04Binding
import dagger.Component
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Singleton

@Singleton
@Component(modules = [UserModule::class])
public interface Component04 {
    fun inject(activity: Activity04)
}

class Activity04 : AppCompatActivity() {

    @Inject
    @YoungUser
    lateinit var user: User

    @Inject
    lateinit var dog: Dog

    private lateinit var binding: Activity04Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = Activity04Binding.inflate(layoutInflater)
        setContentView(binding.root)


        DaggerComponent04.builder().build().inject(this)

        user.name="Hero"
        dog.name="大黄"
        dog.owner.name="小明"

        binding.buttonUser.setOnClickListener {
            binding.textView.text = user.toString()
        }
        binding.buttonDog.setOnClickListener {
            binding.textView.text = dog.toString()
        }
    }
}