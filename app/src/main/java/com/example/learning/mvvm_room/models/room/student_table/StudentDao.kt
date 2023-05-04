package com.example.learning.mvvm_room.models.room.student_table

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface StudentDao {

    @Insert
    suspend fun insertStudent(studentEntity: StudentEntity)

    @Update
    suspend fun updateStudent(studentEntity: StudentEntity)

    @Delete
    suspend fun deleteStudent(studentEntity: StudentEntity)

    @Query("SELECT * FROM Students_Table")
    fun getStudents():LiveData<List<StudentEntity>>

}