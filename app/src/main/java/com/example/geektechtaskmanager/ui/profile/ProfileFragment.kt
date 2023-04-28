package com.example.geektechtaskmanager.ui.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import com.example.geektechtaskmanager.R
import com.example.geektechtaskmanager.databinding.FragmentProfileBinding
import com.example.geektechtaskmanager.ui.model.Profile
import com.example.geektechtaskmanager.ui.model.Task
import com.example.geektechtaskmanager.ui.profile.adapter.ProfileAdapter
import com.example.geektechtaskmanager.ui.task.AvatarFragment
import com.example.geektechtaskmanager.ui.task.TaskFragment


class ProfileFragment : Fragment() {
    // TODO: Rename and change types of parameters

    private lateinit var binding: FragmentProfileBinding

    private val adapter = ProfileAdapter()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.idRecycler2.adapter = adapter

        setFragmentResultListener(AvatarFragment.HOME_REQUEST){ requestKey, bundle ->
            val result = bundle.getSerializable(AvatarFragment.HOME_KEY) as Profile
            adapter.addTask(result)
        }

        binding.idFab2.setOnClickListener {
            findNavController().navigate(R.id.avatarFragment)
        }
    }
}