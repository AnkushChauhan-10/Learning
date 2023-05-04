package com.example.learning.mvvm_room.data_binding_adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.learning.databinding.RowTableListBinding
import com.example.learning.mvvm_room.models.room.student_table.StudentEntity

class TableListAdapter:ListAdapter<StudentEntity,TableListAdapter.Holder>(DiffUtil()){


    class Holder(val viewDataBinding: RowTableListBinding):
        RecyclerView.ViewHolder(viewDataBinding.root){
            fun bind(row: StudentEntity){
                viewDataBinding.student = row
            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = RowTableListBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val studentEntity = getItem(position)
        holder.bind(studentEntity)
    }

    class DiffUtil:androidx.recyclerview.widget.DiffUtil.ItemCallback<StudentEntity>(){
        override fun areItemsTheSame(oldItem: StudentEntity, newItem: StudentEntity): Boolean {
            return oldItem.s_id == newItem.s_id
        }

        override fun areContentsTheSame(oldItem: StudentEntity, newItem: StudentEntity): Boolean {
            return oldItem == newItem
        }
    }

}