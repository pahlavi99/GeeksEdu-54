package com.example.geektechtaskmanager.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import com.example.geektechtaskmanager.R
import com.example.geektechtaskmanager.databinding.FragmentHomeBinding
import com.example.geektechtaskmanager.ui.home.adapter.TaskAdapter
import com.example.geektechtaskmanager.ui.model.Task
import com.example.geektechtaskmanager.ui.task.TaskFragment

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val adapter = TaskAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.idRecycler.adapter = adapter

        setFragmentResultListener(TaskFragment.TASK_REQUEST){ requestKey, bundle ->
            val result = bundle.getSerializable(TaskFragment.TASK_KEY) as Task
            adapter.addTask(result)
        }

        binding.idFab.setOnClickListener {
            findNavController().navigate(R.id.taskFragment)
        }
    }

}