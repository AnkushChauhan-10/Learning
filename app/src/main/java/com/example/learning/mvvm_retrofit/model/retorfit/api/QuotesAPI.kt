package com.example.learning.mvvm_retrofit.model.retorfit.api

import com.example.learning.mvvm_retrofit.model.retorfit.dataclass.QuoteList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface QuotesAPI {

    @GET("/quotes")
    suspend fun getQuotes():Response<QuoteList>
}