package com.example.learning.mvvm_retrofit.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.learning.mvvm_retrofit.model.APIRepo
import com.example.learning.mvvm_retrofit.model.retorfit.dataclass.QuoteList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RetroViewModel(val repo: APIRepo):ViewModel() {

    init{
        viewModelScope.launch(Dispatchers.IO){
            repo.getQuotes(1)
        }
    }
    val quoteList:LiveData<QuoteList>
    get() = repo.quote
}
class RetroViewModelFactory(private val repo: APIRepo):ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return  RetroViewModel(repo) as T
    }
}