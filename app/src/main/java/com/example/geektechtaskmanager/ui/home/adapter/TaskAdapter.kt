package com.example.geektechtaskmanager.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.geektechtaskmanager.databinding.ItemTaskBinding
import com.example.geektechtaskmanager.ui.model.Task

class TaskAdapter(
    private val onLongClick : (Task) -> Unit
) : RecyclerView.Adapter<TaskAdapter.TaskViewHolder>(){

    private var arrayList = ArrayList<Task>()


    fun addTask(task: Task)
    {
        arrayList.add(0, task)
        notifyDataSetChanged()
    }
    fun addTasks(tasks: List<Task>)
    {
        arrayList.clear()
        arrayList.addAll(tasks)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskAdapter.TaskViewHolder {
        return TaskViewHolder(ItemTaskBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: TaskAdapter.TaskViewHolder, position: Int) {
        holder.bind(arrayList[position])
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    inner class TaskViewHolder(var binding: ItemTaskBinding) : ViewHolder(binding.root)
    {
        fun bind(task: Task)
        {
            binding.tvTitle.text = task.title
            binding.tvDesc.text = task.description
            binding.root.setOnLongClickListener{
                onLongClick(task)
                false
            }
        }
    }
}