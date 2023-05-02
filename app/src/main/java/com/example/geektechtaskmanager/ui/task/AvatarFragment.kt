package com.example.geektechtaskmanager.ui.task

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import com.example.geektechtaskmanager.data.local.Pref
import com.example.geektechtaskmanager.databinding.FragmentAvatarBinding
import com.example.geektechtaskmanager.ui.model.Profile

class AvatarFragment : Fragment() {

    private lateinit var binding: FragmentAvatarBinding
    private lateinit var pref: Pref


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAvatarBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pref = Pref(requireContext())


        binding.idButton2.setOnClickListener {
            val profile = Profile(
                image = binding.idImage.imageAlpha,
                name = binding.idDescription.text.toString()
            )
            setFragmentResult(HOME_REQUEST, bundleOf(HOME_KEY to profile))
            findNavController().navigateUp()
        }
        binding.idDescription.setText(pref.getUserName())
        binding.idDescription.addTextChangedListener {
            pref.saveUserName(binding.idDescription.text.toString())
        }

        binding.idImage.setOnClickListener{
            getImageFromGallery()
        }
    }
    private fun  getImageFromGallery()
    {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, IMAGE_REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == IMAGE_REQUEST_CODE && resultCode == RESULT_OK)
        {
            binding.idImage.setImageURI(data?.data)
        }
    }
    companion object
    {
        const val HOME_REQUEST = "home.request.code"
        const val HOME_KEY = "home.key"
        const val IMAGE_REQUEST_CODE = 1
    }
}