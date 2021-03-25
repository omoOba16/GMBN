package com.example.gmbn.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gmbn.databinding.CommentItemLayoutBinding
import com.example.gmbn.model.comments.Items
import java.util.ArrayList

class CommentsAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var data: MutableList<Items>? = ArrayList()

    fun addComments(items: List<Items>) {
        data?.apply {
            clear()
            addAll(items)
            notifyDataSetChanged()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val commentItemLayoutBinding =  CommentItemLayoutBinding.inflate(layoutInflater)
        return CommentViewHolder(commentItemLayoutBinding)
    }

    override fun getItemCount(): Int {
        return if (data == null) 0 else data!!.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is CommentViewHolder -> holder.apply {
                holder.bind(data!![position])
            }
        }
    }

    class CommentViewHolder(private val binding: CommentItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Items){
            binding.item = data
            binding.executePendingBindings()
        }
    }
}