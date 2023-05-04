package com.example.learning.mvvm_room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.learning.R
import com.example.learning.databinding.ActivityMvvmactivityBinding
import com.example.learning.mvvm_room.data_binding_adapter.TableListAdapter
import com.example.learning.mvvm_room.models.MVVMRepository
import com.example.learning.mvvm_room.models.room.MVVMDataBase
import com.example.learning.mvvm_room.models.room.student_table.StudentEntity
import com.example.learning.mvvm_room.viewmodel.MVVMViewModel
import com.example.learning.mvvm_room.viewmodel.MVVMViewModelFactory

class MVVMRoomActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMvvmactivityBinding
    private lateinit var viewModel: MVVMViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_mvvmactivity)

        val DB = MVVMDataBase.getDataBase(this)
        val repo = MVVMRepository(DB.getStudentDao())

        viewModel = ViewModelProvider(this,MVVMViewModelFactory(repo)).get(MVVMViewModel::class.java)

        binding.lifecycleOwner = this

        binding.viewModel = viewModel

        binding.insert.setOnClickListener {
            viewModel.insert(student())
        }
        binding.delete.setOnClickListener {
            viewModel.delete(student())
        }
        binding.update.setOnClickListener {
            viewModel.update(student())
        }

        val adapter = TableListAdapter()
        viewModel.studentList.observe(this,{
            adapter.submitList(it)
        })
        binding.rowRecycleView.layoutManager = LinearLayoutManager(this)
        binding.rowRecycleView.adapter = adapter
    }

    private fun student():StudentEntity{
        return StudentEntity(binding.id.text.toString().toLong(),
        binding.name.text.toString(),
        binding.roll.text.toString().toInt(),
        binding.cls.text.toString(),"2010/02/16")
    }
}