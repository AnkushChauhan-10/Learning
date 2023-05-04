package com.example.learning.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException


class Viewmodel(private val C:Int  = 0): ViewModel() {

    private var count:Int = C

    fun increment(){
        count++
    }

    fun getCount():Int{
        return count
    }
}

class ViewFactory(private val c :Int): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return Viewmodel(c) as T
    }
}