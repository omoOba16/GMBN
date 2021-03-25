package com.example.gmbn.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.gmbn.databinding.VideoItemLayoutBinding
import com.example.gmbn.model.Items

class VideoAdapter(private val mListener: VideoItemClickListener): PagedListAdapter<Items, RecyclerView.ViewHolder>(ItemsDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val videoItemLayoutBinding =  VideoItemLayoutBinding.inflate(layoutInflater)
        return VideoViewHolder(videoItemLayoutBinding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = getItem(position)
        when (holder) {
            is VideoViewHolder -> holder.apply {
                holder.bind(item!!, mListener)
            }
        }
    }

    class VideoViewHolder(private val binding: VideoItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Items, listener : VideoItemClickListener){
            binding.item = data
            binding.itemClick = listener
            binding.executePendingBindings()
        }
    }

    interface VideoItemClickListener {
        fun onVideoItemClickListener(videoId: String)
    }
}

private class ItemsDiffCallback : DiffUtil.ItemCallback<Items>() {

    override fun areItemsTheSame(oldItem: Items, newItem: Items): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Items, newItem: Items): Boolean {
        return oldItem == newItem
    }
}