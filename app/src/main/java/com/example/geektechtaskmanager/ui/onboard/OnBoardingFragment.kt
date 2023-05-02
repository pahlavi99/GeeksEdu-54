package com.example.geektechtaskmanager.ui.onboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.geektechtaskmanager.data.local.Pref
import com.example.geektechtaskmanager.databinding.FragmentOnBoardingBinding
import com.example.geektechtaskmanager.ui.model.OnBoard

class OnBoardingFragment : Fragment() {
    // TODO: Rename and change types of parameters

    private lateinit var binding: FragmentOnBoardingBinding
    private lateinit var pref: Pref

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnBoardingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = OnBoardingAdapter(this::onClick)
        pref = Pref(requireContext())
        binding.idViewPager.adapter = adapter
        binding.indicator.setViewPager(binding.idViewPager)
        adapter.registerAdapterDataObserver(binding.indicator.adapterDataObserver)
    }

    private fun onClick(onBoard: OnBoard)
    {
        findNavController().navigateUp()
        pref.saveUserSeen()
    }
}