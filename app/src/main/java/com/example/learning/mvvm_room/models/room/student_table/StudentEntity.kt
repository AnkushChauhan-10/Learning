package com.example.learning.mvvm_room.models.room.student_table

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Students_Table")
data class StudentEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "s_id")
    val s_id:Long,
    @ColumnInfo(name = "s_name")
    val s_name:String,
    @ColumnInfo(name = "s_roll")
    val s_rollNo:Int,
    @ColumnInfo(name ="s_class")
    val s_class:String,
    @ColumnInfo(name = "dob")
    val dob:String )
