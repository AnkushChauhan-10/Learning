package com.example.learning.mvvm_room.models

import androidx.lifecycle.LiveData
import com.example.learning.mvvm_room.models.room.student_table.StudentDao
import com.example.learning.mvvm_room.models.room.student_table.StudentEntity

class MVVMRepository(private val studentDao: StudentDao) {

    fun getStudents():LiveData<List<StudentEntity>>{
        return studentDao.getStudents()
    }

    suspend fun insert(studentEntity: StudentEntity){
        studentDao.insertStudent(studentEntity)
    }

    suspend fun update(studentEntity: StudentEntity){
        studentDao.updateStudent(studentEntity)
    }

    suspend fun delete(studentEntity: StudentEntity){
        studentDao.deleteStudent(studentEntity)
    }
}