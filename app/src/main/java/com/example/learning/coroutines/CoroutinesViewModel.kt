package com.example.learning.coroutines

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.*
import kotlinx.coroutines.*
import kotlin.concurrent.thread

class CoroutinesViewModel(val context: Context):ViewModel(){

    private val mutableData = MutableLiveData<Int>(0)
    val data: LiveData<Int> = mutableData

    private fun increment(){
        mutableData.value?.let { a-> mutableData.value = a+1 }
    }

    private fun createToast(msg:String):Toast{
        return Toast.makeText(context,msg,Toast.LENGTH_LONG)
    }

    private fun longRun(){
       Thread.sleep(3000)
    }
    //------------------------------No Thread ------------------------
    fun withOutThread(){
        val toast = createToast("with Out Thread = ")
        longRun()
        increment()
        toast.show()
    }
    //------------------------------Thread-------------------------------------------------
    fun withThread(){
        val toast = createToast("With Thread = ")
        thread(start = true) {
            longRun()
            toast.show()
            Log.d("Thread",Thread.currentThread().name)
        }
        increment()
    }

    //----------------------------- Coroutines -----------------------------------------
    fun coroutinesScope(){
        val toast = createToast("CoroutineScope(Dispatchers.Default)")
        CoroutineScope(Dispatchers.Default).launch {
            longRun()
            Log.d("Coroutine Scope",Thread.currentThread().name)
            toast.show()
        }
        increment()
    }
    fun globalScope(){
        val toast = createToast("GlobalScope.launch(Dispatchers.IO)")
        GlobalScope.launch(Dispatchers.IO) {
            longRun()
            Log.d("Global Scope",Thread.currentThread().name)
            toast.show()
        }
        increment()
    }
    fun mainScope(){
        MainScope().launch(Dispatchers.Main) {
            val toast = createToast("MainScope().launch(Dispatchers.Main)"+Thread.currentThread().name)
            longRun()
            Log.d("Main Scope",Thread.currentThread().name)
            toast.show()
        }
        increment()
    }

    //--------------------------------------------Suspended----------------------------------------
    fun suspendedTask(){
        CoroutineScope(Dispatchers.IO).launch {
            task1()
        }
        GlobalScope.launch(Dispatchers.IO) {
            task2()
        }
    }

    private suspend fun task1(){
        Log.d("Suspended","Task 1 Start")
       delay(3000)
        Log.d("Suspended","Task 1 End")
    }
    private suspend fun task2(){
        Log.d("Suspended","Task 2 Start")
        delay(3000)
        Log.d("Suspended","Task 2 End")
    }

    //-------------------------------------------Coroutines Builder-------------------------------

    fun builder(){
        CoroutineScope(Dispatchers.IO).launch {
            val task1 = async { getTask1() }
            val task2 = async { getTask2() }
            Log.d("Builder","Task 1 = ${task1.await()},  Task 2 = ${task2.await()}")
        }
    }

    private suspend fun getTask1():Int{
        Log.d("Builder","Get Task 1 Start")
        delay(6000)
        Log.d("Builder","Get Task 1 End")
        return 2
    }
    private suspend fun getTask2():Int{
        Log.d("Builder","Get Task 2 Start")
        delay(6000)
        Log.d("Builder","Get Task 2 End")
        return  3
    }

    //-----------------------------With Context-----------------------------------------

    fun withContext(){
        viewModelScope.launch(Dispatchers.IO) {
            val sum:Int
            withContext(Dispatchers.IO){
                sum  = contextTask1()+contextTask2()
            }
            Log.d("With Context",sum.toString())
            withContext(Dispatchers.Main){
                mutableData.value = sum
            }
        }
    }

    private suspend fun contextTask1():Int{
        Log.d("With Context","Context Task 1 Start")
        delay(6000)
        Log.d("With Context","Context Task 1 End")
        return  300
    }
    private suspend fun contextTask2():Int{
        Log.d("With Context","Context Task 2 Start")
        delay(6000)
        Log.d("With Context","Context Task 2 End")
        return  400
    }
}

class CoroutinesViewModelFactory(val context: Context):ViewModelProvider.Factory{
    override fun <T:ViewModel> create(modelClass : Class<T>):T{
        return CoroutinesViewModel(context) as T
    }
}