package com.demo.d

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.demo.R
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ActivityDefaultBinding : AppCompatActivity() {

    @Inject
    lateinit var user: User

    @Inject
    lateinit var user2: User

    @Inject
    lateinit var viewModel: ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hilt)

        val infoView: TextView = findViewById(R.id.info_view)

        infoView.text = "user = $user \n" +
                "user2 = $user2 \n" +
                "viewModel = $viewModel"
    }
}