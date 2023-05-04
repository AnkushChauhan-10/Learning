package com.example.learning

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import com.example.learning.coroutines.CoroutinesActivity
import com.example.learning.databinding.DataBindingActivity
import com.example.learning.lifecycleobserver.LifeCycleObserverActivity
import com.example.learning.livedata.LiveDataActivity
import com.example.learning.mvvm_retrofit.MVVMRetrofitActivity
import com.example.learning.mvvm_room.MVVMRoomActivity
import com.example.learning.viewmodel.ViewModelActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val list = arrayListOf("Life Cycle","View Model","Live Data","Data Binding","Coroutines","MVVM Room","MVVM Retrofit")
        val listView = findViewById<ListView>(R.id.list_item)
        val arrayAdapter = ArrayAdapter(this,R.layout.main_list_item,R.id.textViewList,list)

        listView.adapter = arrayAdapter

        listView.setOnItemClickListener { parent, view, position, id ->
            when(position){
                0->{
                    val intent = Intent(this,LifeCycleObserverActivity::class.java)
                    startActivity(intent)
                }
                1->{
                    val intent = Intent(this,ViewModelActivity::class.java)
                    startActivity(intent)
                }
                2->{
                    val intent = Intent(this,LiveDataActivity::class.java)
                    startActivity(intent)
                }
                3->{
                    val intent = Intent(this,DataBindingActivity::class.java)
                    startActivity(intent)
                }
                4->{
                    val intent = Intent(this,CoroutinesActivity::class.java)
                    startActivity(intent)
                }
                5->{
                    val intent = Intent(this,MVVMRoomActivity::class.java)
                    startActivity(intent)
                }
                6->{
                    val intent = Intent(this,MVVMRetrofitActivity::class.java)
                    startActivity(intent)
                }
            }
        }
    }
}