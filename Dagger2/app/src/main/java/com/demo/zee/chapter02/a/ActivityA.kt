package com.demo.zee.chapter02.a

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.demo.R
import dagger.Component
import javax.inject.Inject

// 1. 在构造方法上使用@Inject注解，就是告诉Dagger可以通过这个方法来实例化一个User对象
class User @Inject constructor() {
    val name = "User from @Inject constructor()"
}

// 2. 定义一个Dagger组件，@Component注解会生成一个实现类，以Dagger打头，即DaggerApplicationComponent
// 这个类是个容器，管理很多对象实例，比如User对象实例
@Component
interface ApplicationComponent {
    // 3. 指定要注入到哪个类里
    fun inject(activity: ActivityA)
}

/**
 * 使用Dagger快速实现依赖注入
 */

class ActivityA : AppCompatActivity() {

    // 4. 在属性上使用@Inject，告诉Dagger这个属性需要注入
    @Inject
    lateinit var user: User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dagger)

        // 5. 手动执行注入动作，执行完后user已经实例化
        // 如果编译器找不到这个类，需要重新Rebuild工程
        DaggerApplicationComponent.create().inject(this)

        val infoView: TextView = findViewById(R.id.info_view)
        infoView.text = user.name
    }
}