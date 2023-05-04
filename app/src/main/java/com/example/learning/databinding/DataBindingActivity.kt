package com.example.learning.databinding

import android.database.DatabaseUtils
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.learning.R

class DataBindingActivity : AppCompatActivity() {

    lateinit var dataBindingActivity: ActivityDataBindingBinding
    lateinit var viewModel: DataViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBindingActivity = DataBindingUtil.setContentView(this,R.layout.activity_data_binding)

        viewModel = ViewModelProvider(this,DataViewModelFactory()).get(DataViewModel::class.java)
        dataBindingActivity.viewModel = viewModel

        //Normal Data Binding
        dataBindingActivity.book = Book("Phdkd","Ankush")

        //Pass lifecycle owner for Live Data
        dataBindingActivity.lifecycleOwner = this

        //Binding adapters
        dataBindingActivity.exp = Exp("sdasd","xcxcxc","https://my.alfred.edu/zoom/_images/foster-lake.jpg")
    }
}