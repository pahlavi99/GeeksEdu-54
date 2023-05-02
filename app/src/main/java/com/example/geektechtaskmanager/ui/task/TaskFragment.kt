package com.example.geektechtaskmanager.ui.task

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import com.example.geektechtaskmanager.App
import com.example.geektechtaskmanager.R
import com.example.geektechtaskmanager.databinding.FragmentTaskBinding
import com.example.geektechtaskmanager.ui.model.Task

class TaskFragment : Fragment() {

    lateinit var binding: FragmentTaskBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTaskBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.idButton.setOnClickListener {
            save()
        }
    }
    private fun save()
    {
        val data = Task(
            title = binding.etTitle.text.toString(),
            description = binding.etDes.text.toString()
        )
        App.db.taskDao().insert(data)
        findNavController().navigateUp()
    }
    companion object {
        const val TASK_REQUEST = "task.requestKey"
        const val TASK_KEY = "task.key"
    }
}