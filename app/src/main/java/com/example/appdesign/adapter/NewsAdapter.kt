package com.example.appdesign.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.appdesign.R
import com.example.appdesign.databinding.ItemLayoutBinding
import com.example.appdesign.interfaces.NewsAdapterClickItem

class NewsAdapter(private val listener: NewsAdapterClickItem) : ListAdapter<News, NewsAdapter.NewsViewHolder>(NewsDiffCallback()) {

    class NewsViewHolder(private val binding: ItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: News, listener: NewsAdapterClickItem) {
            binding.imageView.setImageResource(item.imageResId)
            binding.textView1.text = item.text1
            binding.textView2.text = item.text2
            binding.textView3.text = item.text3

            binding.llAllView.setOnClickListener {
                listener.onButtonClick()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemLayoutBinding.inflate(inflater, parent, false)
        return NewsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item, listener)
    }

    class NewsDiffCallback : DiffUtil.ItemCallback<News>() {
        override fun areItemsTheSame(oldItem: News, newItem: News): Boolean {
            return oldItem.imageResId == newItem.imageResId
        }

        override fun areContentsTheSame(oldItem: News, newItem: News): Boolean {
            return oldItem == newItem
        }
    }
}

data class News(val imageResId: Int, val text1: String, val text2: String, val text3: String)
