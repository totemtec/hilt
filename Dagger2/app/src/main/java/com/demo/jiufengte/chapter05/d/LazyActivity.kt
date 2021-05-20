package com.demo.jiufengte.chapter05.d

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.demo.databinding.Activity05dBinding
import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Inject

class ExpensiveObject {

    var intArray: IntArray = IntArray(1000001)
    var byteArray: ByteArray = ByteArray(1000001)

    init {
        for(i in 0..1000000) {
            intArray[i] = i
        }

        for(i in 0..1000000) {
            byteArray[i] = i.toByte()
        }
    }
}

@Module
class MyModule {
    @Provides
    fun provideExpensiveObject(): ExpensiveObject = ExpensiveObject()
}

@Component(modules = [MyModule::class])
interface MainComponent {
    fun inject(activity: LazyActivity)
}

class LazyActivity : AppCompatActivity() {

    private lateinit var binding: Activity05dBinding

    /**
     * 注意这里要使用dagger.Lazy，不要使用kotlin.Lazy
     */
    @Inject
    lateinit var expensiveObject: dagger.Lazy<ExpensiveObject>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = Activity05dBinding.inflate(layoutInflater)
        setContentView(binding.root)

        DaggerMainComponent.builder().myModule(MyModule()).build().inject(this)

        binding.button.setOnClickListener {
            binding.infoView.text = "Size is ${expensiveObject.get().intArray?.size}"
        }
    }
}