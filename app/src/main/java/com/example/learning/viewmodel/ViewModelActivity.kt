package com.example.learning.viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.learning.R

class ViewModelActivity : AppCompatActivity() {
    lateinit var viewmodel: Viewmodel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_model)

//        viewmodel = ViewModelProvider(this).get(Viewmodel::class.java)
        viewmodel = ViewModelProvider(this,ViewFactory(20)).get(Viewmodel::class.java)

        val button = findViewById<Button>(R.id.button)
        val text = findViewById<TextView>(R.id.textView)

        button.setOnClickListener {
            viewmodel.increment()
            text.text = viewmodel.getCount().toString()
        }
    }
}