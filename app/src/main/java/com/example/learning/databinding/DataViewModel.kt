package com.example.learning.databinding

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class DataViewModel:ViewModel() {
    private val mutableData : MutableLiveData<Int> = MutableLiveData(0)
    val data : LiveData<Int> = mutableData
    val mutableText : MutableLiveData<String> = MutableLiveData("This")
    fun increase(){
        mutableData.value = mutableData.value!! + 1
    }
}

class DataViewModelFactory: ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return DataViewModel() as T
    }
}