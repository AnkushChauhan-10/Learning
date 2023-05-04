package com.example.learning.mvvm_retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ReportFragment.Companion.reportFragment
import androidx.lifecycle.ViewModelProvider
import com.example.learning.R
import com.example.learning.databinding.ActivityMvvmretrofitBinding
import com.example.learning.mvvm_retrofit.model.APIRepo
import com.example.learning.mvvm_retrofit.model.retorfit.RetrofitHelper
import com.example.learning.mvvm_retrofit.model.retorfit.api.QuotesAPI
import com.example.learning.mvvm_retrofit.view_model.RetroViewModel
import com.example.learning.mvvm_retrofit.view_model.RetroViewModelFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MVVMRetrofitActivity : AppCompatActivity() {
    private lateinit var viewModel: RetroViewModel
    private lateinit var binding: ActivityMvvmretrofitBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_mvvmretrofit)
        binding.lifecycleOwner = this
        val quote = RetrofitHelper.getInstance().create(QuotesAPI::class.java)
        val repo = APIRepo(quote)
        viewModel = ViewModelProvider(this,RetroViewModelFactory(repo)).get(RetroViewModel::class.java)
        binding.viewModel = viewModel
        viewModel.quoteList.observe(this,{
            Log.d("API",it.toString())
        })

    }
}