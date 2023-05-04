package com.example.learning.livedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.learning.R
import org.w3c.dom.Text

class LiveDataActivity : AppCompatActivity() {
    lateinit var viewModel: LiveViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_live_data)

        var text = findViewById<TextView>(R.id.liveText)

        viewModel = ViewModelProvider(this,LiveViewModelFactory(2)).get(LiveViewModel::class.java)

        findViewById<Button>(R.id.liveButton).setOnClickListener {
            viewModel.increment()
        }

        viewModel.data.observe(this,{
            text.text = it.toString()
        })

    }
}