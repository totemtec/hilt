package com.demo.jiufengte.chapter01

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.demo.R
import dagger.Component
import javax.inject.Inject

class IdCard(val number: Long, val name: String, val address: String, val age: Int)

class Person(val company: String, val idCard: IdCard) {
    override fun toString(): String {
        return "姓名：${idCard.name}," +
                " 公司: $company," +
                " 身份证号: ${idCard.number}" +
                " 地址: ${idCard.address}" +
                " 年龄: ${idCard.age}"
    }
}

//@Inject标记了，而且标记的是构造函数. 这会让dagger知道怎么创建User实例。

class User @Inject constructor() {
    var name: String? = null
    override fun toString(): String {
        return "Name: $name"
    }
}

@Component
public interface Component01 {
    fun inject(activity: Activity01)
}

class Activity01 : AppCompatActivity() {

    val xiaoMing = Person("首钢", IdCard(1000, "小明", "北京望京南", 28))
    val xiaoHong = Person("北汽", IdCard(2000, "小红", "南京新街口", 18))


    @Inject
    lateinit var user: User

    private lateinit var textView: TextView
    private lateinit var xiaoMingbutton: Button
    private lateinit var xiaoHongButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_01)


        textView = findViewById(R.id.textView)
        xiaoHongButton = findViewById(R.id.xiaohongButton)
        xiaoHongButton.setOnClickListener {
            textView.text = xiaoHong.toString()
        }
        xiaoMingbutton = findViewById(R.id.xiaomingButton)
        xiaoMingbutton.setOnClickListener {
            textView.text = xiaoMing.toString()
        }

//        user = User()
//        user.name = "Haha"

        DaggerComponent01.builder().build().inject(this)

        user.name="注入的对象"


        xiaoMingbutton.setOnClickListener {
            textView.text = user.toString()
        }
    }
}