package com.example.geektechtaskmanager.ui.onboard

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.geektechtaskmanager.databinding.ItemOnBoardBinding
import com.example.geektechtaskmanager.ui.model.OnBoard
import com.example.geektechtaskmanager.ui.utils.loadImage

class OnBoardingAdapter(
    private val onClick: (OnBoard) -> Unit) : Adapter<OnBoardingAdapter.OnBoardingViewHolder>(){

    val data = arrayListOf(
        OnBoard("Title 1", "Desc 1", "https://cdn-icons-png.flaticon.com/512/2098/2098402.png"),
        OnBoard("Title 2", "Desc 2", "https://cdn-icons-png.flaticon.com/512/2098/2098402.png"),
        OnBoard("Title 3", "Desc 3", "https://cdn-icons-png.flaticon.com/512/2098/2098402.png"))

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardingViewHolder {
        return OnBoardingViewHolder(ItemOnBoardBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: OnBoardingViewHolder, position: Int) {
        holder.bind(data[position])
    }

    inner class OnBoardingViewHolder(private val binding: ItemOnBoardBinding) : ViewHolder(binding.root)
    {
        fun bind(onBoard: OnBoard)
        {
            binding.btnStart.setOnClickListener {
                onClick(onBoard)
            }

            binding.tvTitle.text = onBoard.title
            binding.tvDesc.text = onBoard.description
            binding.ivBoard.loadImage(onBoard.image)
        }
    }
}