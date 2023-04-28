package com.example.geektechtaskmanager.ui.profile.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.geektechtaskmanager.databinding.ItemProfileBinding
import com.example.geektechtaskmanager.ui.model.Profile
import com.example.geektechtaskmanager.ui.model.Task

class ProfileAdapter : RecyclerView.Adapter<ProfileAdapter.ProfileViewHolder>() {

    private val arrayList = ArrayList<Profile>()

    fun addTask(profile: Profile)
    {
        arrayList.add(0, profile)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProfileAdapter.ProfileViewHolder {
        return ProfileViewHolder(ItemProfileBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ProfileAdapter.ProfileViewHolder, position: Int) {
        holder.bind(arrayList[position])
    }

    override fun getItemCount(): Int {
       return arrayList.size
    }

    class ProfileViewHolder(private val binding: ItemProfileBinding) : ViewHolder(binding.root)
    {
        fun bind(profile: Profile)
        {
            binding.idImageProfile.imageAlpha = profile.image!!
            binding.idNameProfile.text = profile.name
        }
    }
}