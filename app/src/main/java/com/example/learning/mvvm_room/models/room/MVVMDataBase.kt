package com.example.learning.mvvm_room.models.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.learning.mvvm_room.models.room.student_table.StudentDao
import com.example.learning.mvvm_room.models.room.student_table.StudentEntity

@Database(entities = [StudentEntity::class], version = 2)
abstract class MVVMDataBase():RoomDatabase(){

    abstract fun getStudentDao(): StudentDao

    companion object{

        val migration_1_2 = object : Migration(1,2){
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE Students_Table ADD COLUMN dob VARCHAR(10) NOT NULL DEFAULT(1)")
            }
        }

        @Volatile
        private var INSTANCES: MVVMDataBase?= null
        fun getDataBase(context: Context): MVVMDataBase {
            if(INSTANCES == null){
                synchronized(this){
                    INSTANCES = Room.databaseBuilder(context.applicationContext,
                    MVVMDataBase::class.java,
                    "MVVM")
                        .addMigrations(migration_1_2)
                        .build()
                }
            }
            return INSTANCES!!
        }
    }
}