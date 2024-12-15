package com.example.appdesign.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.appdesign.R
import com.example.appdesign.databinding.BotMessageBinding
import com.example.appdesign.databinding.DateSupportBinding
import com.example.appdesign.databinding.YourMessageBinding

class MessageAdapter : ListAdapter<Message, RecyclerView.ViewHolder>(MessageDiffCallback()) {

    companion object {
        const val TYPE_BOT = 0
        const val TYPE_USER = 1
        const val TYPE_DATE = 2
    }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is Message.BotMessage -> TYPE_BOT
            is Message.YourMessage -> TYPE_USER
            is Message.DateMessage -> TYPE_DATE
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            TYPE_BOT -> {
                val binding = BotMessageBinding.inflate(inflater, parent, false)
                BotMessageViewHolder(binding)
            }
            TYPE_USER -> {
                val binding = YourMessageBinding.inflate(inflater, parent, false)
                YourMessageViewHolder(binding)
            }
            TYPE_DATE -> {
                val binding = DateSupportBinding.inflate(inflater, parent, false)
                DateSupportViewHolder(binding)
            }
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is BotMessageViewHolder -> holder.bind((getItem(position) as Message.BotMessage).message)
            is YourMessageViewHolder -> holder.bind((getItem(position) as Message.YourMessage).message)
            is DateSupportViewHolder -> holder.bind((getItem(position) as Message.DateMessage).date)
        }
    }

    inner class BotMessageViewHolder(private val binding: BotMessageBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(message: String) {
            binding.tvMessage.text = message
        }
    }

    inner class YourMessageViewHolder(private val binding: YourMessageBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(message: String) {
            binding.tvMessage.text = message
        }
    }
    inner class DateSupportViewHolder(private val binding: DateSupportBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(message: String) {
            binding.tvDate.text = message
        }
    }
}

class MessageDiffCallback : DiffUtil.ItemCallback<Message>() {
    override fun areItemsTheSame(oldItem: Message, newItem: Message): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Message, newItem: Message): Boolean {
        return oldItem == newItem
    }
}


sealed class Message {
    data class BotMessage(val message: String) : Message()
    data class YourMessage(val message: String) : Message()
    data class DateMessage(val date: String) : Message()
}

