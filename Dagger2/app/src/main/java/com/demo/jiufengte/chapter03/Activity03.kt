package com.demo.jiufengte.chapter03

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.demo.databinding.Activity03Binding
import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Inject
import javax.inject.Singleton

class User @Inject constructor(val age: Int) {
    var name: String? = null
    override fun toString(): String {
        return "Name: $name , Age: $age"
    }
}

@Module
class UserModule
{
    @Singleton
    @Provides
    fun provideUser():User
    {
        return User(28)
    }
}

class Dog @Inject constructor(val owner: User) {
    lateinit var name: String
    override fun toString(): String {
        return "Dog: $name, Owner: ${owner.name} Owner Age: ${owner.age}"
    }
}

@Singleton
@Component(modules = [UserModule::class])
public interface Component03 {
    fun inject(activity: Activity03)
}

class Activity03 : AppCompatActivity() {

    @Inject
    lateinit var user: User

    @Inject
    lateinit var dog: Dog

    private lateinit var binding: Activity03Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = Activity03Binding.inflate(layoutInflater)
        setContentView(binding.root)


        DaggerComponent03.builder().build().inject(this)

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