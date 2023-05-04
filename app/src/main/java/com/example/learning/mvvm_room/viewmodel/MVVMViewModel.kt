package com.example.learning.mvvm_room.viewmodel

import androidx.lifecycle.*
import com.example.learning.mvvm_room.models.MVVMRepository
import com.example.learning.mvvm_room.models.room.student_table.StudentEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MVVMViewModel(private val mvvmRepository: MVVMRepository):ViewModel() {

    val studentList: LiveData<List<StudentEntity>> = mvvmRepository.getStudents()


    fun insert(studentEntity: StudentEntity){
        viewModelScope.launch(Dispatchers.IO){
            mvvmRepository.insert(studentEntity)
        }
    }

    fun update(studentEntity: StudentEntity){
        viewModelScope.launch(Dispatchers.IO){
            mvvmRepository.update(studentEntity)
        }
    }

    fun delete(studentEntity: StudentEntity){
        viewModelScope.launch(Dispatchers.IO){
            mvvmRepository.delete(studentEntity)
        }
    }

}


class MVVMViewModelFactory(private val mvvmRepository: MVVMRepository):ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return  MVVMViewModel(mvvmRepository) as T
    }
}