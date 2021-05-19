package com.demo.chapter04a

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.demo.databinding.Activity04Binding
import dagger.Component
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
@Component(modules = [UserModule::class, EngineModule::class])
public interface Component04a {
    fun inject(activity: Activity04a)
}

class Activity04a : AppCompatActivity() {

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


        DaggerComponent04a.builder().build().inject(this)

        user.name="Hero"
        user.car.name="速腾"
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