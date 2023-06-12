package com.example.apitest.adapater

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.apitest.dataClass.Posts
import com.example.apitest.databinding.ContainerBinding


class PostsAdapter(private val arrposts: List<Posts>) : RecyclerView.Adapter<PostsAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: ContainerBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(post: Posts) {
            binding.tvUserid.text = post.userid.toString()
            binding.tvId.text = post.id.toString()
            binding.tvTitle.text = post.title
            binding.tvBody.text = post.body

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ContainerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val post = arrposts[position]
        holder.bind(post)
    }

    override fun getItemCount(): Int {
        return arrposts.size
    }
}

