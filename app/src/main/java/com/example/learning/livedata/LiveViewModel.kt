package com.example.learning.livedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.learning.viewmodel.Viewmodel

class LiveViewModel(private val C: Int): ViewModel() {

        private val liveData : MutableLiveData<Int> = MutableLiveData(0)
        val data : LiveData<Int> = liveData
        fun increment(){
            liveData.value = liveData.value!! + 1
        }
}
class LiveViewModelFactory(private val C:Int):ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return LiveViewModel(C) as T
    }
}