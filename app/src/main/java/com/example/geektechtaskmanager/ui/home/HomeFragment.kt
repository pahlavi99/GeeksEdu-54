package com.example.geektechtaskmanager.ui.home

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import com.example.geektechtaskmanager.App
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

    private val adapter = TaskAdapter(onLongClick = this::onLongClick)

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

        val list = App.db.taskDao().getAll()
        adapter.addTasks(list)
        binding.idFab.setOnClickListener {
            findNavController().navigate(R.id.taskFragment)
        }
    }

    private fun onLongClick(task: Task)
    {
        val builder = AlertDialog.Builder(context)
        builder.setTitle("Delete Room")
        builder.setMessage("Do you want to delete an item")
            .setPositiveButton("YES",
                DialogInterface.OnClickListener {dialog, which ->
                    App.db.taskDao().delete(task)
                    dialog.dismiss()
                })
            .setNegativeButton("NO",
                DialogInterface.OnClickListener { dialog, which ->
                    dialog.dismiss()
                })
        // Create the AlertDialog object and return it
        builder.create().show()

    }
}