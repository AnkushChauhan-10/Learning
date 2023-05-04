package com.example.learning.mvvm_retrofit.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.learning.mvvm_retrofit.model.retorfit.api.QuotesAPI
import com.example.learning.mvvm_retrofit.model.retorfit.dataclass.QuoteList

class APIRepo(private val retro:QuotesAPI) {

    private val mutableQuote = MutableLiveData<QuoteList>()
    val quote:LiveData<QuoteList>
    get() = mutableQuote

    suspend fun getQuotes(page:Int){
        val res = retro.getQuotes()
        if(res?.body() != null){
            mutableQuote.postValue(res.body())
        }
    }

}