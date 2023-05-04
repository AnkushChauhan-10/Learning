package com.example.learning.coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.learning.R
import com.example.learning.databinding.ActivityCoroutinesBinding

class CoroutinesActivity : AppCompatActivity() {
    lateinit var binding: ActivityCoroutinesBinding
    lateinit var viewModel: CoroutinesViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_coroutines)

        viewModel = ViewModelProvider(this,CoroutinesViewModelFactory(this.applicationContext)).get(CoroutinesViewModel::class.java)

        binding.viewModel = viewModel
        binding.lifecycleOwner = this

    }

}