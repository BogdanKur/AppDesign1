package com.example.appdesign.adapter

import android.graphics.pdf.models.ListItem
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.RequiresExtension
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.appdesign.R
import com.example.appdesign.databinding.DateItemBinding
import com.example.appdesign.databinding.ItemTransactionBinding

class TransactionAdapter : ListAdapter<TransactionAdapter.TransactionItem, RecyclerView.ViewHolder>(TransactionDiffCallback()) {

    companion object {
        private const val TYPE_DATE = 0
        private const val TYPE_TRANSACTION = 1
    }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is TransactionItem.Date -> TYPE_DATE
            is TransactionItem.Transaction -> TYPE_TRANSACTION
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TYPE_DATE -> {
                val binding = DateItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                DateViewHolder(binding)
            }
            TYPE_TRANSACTION -> {
                val binding = ItemTransactionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                TransactionViewHolder(binding)
            }
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is DateViewHolder -> holder.bind((getItem(position) as TransactionItem.Date).date)
            is TransactionViewHolder -> holder.bind((getItem(position) as TransactionItem.Transaction).name)
        }
    }

    class TransactionViewHolder(private val binding: ItemTransactionBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(transactionName: String) {
            binding.tvTransactionName.text = transactionName
        }
    }

    class DateViewHolder(private val binding: DateItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(date: String) {
            binding.tvDate.text = date
        }
    }

    class TransactionDiffCallback : DiffUtil.ItemCallback<TransactionItem>() {
        override fun areItemsTheSame(oldItem: TransactionItem, newItem: TransactionItem): Boolean {
            return when {
                oldItem is TransactionItem.Date && newItem is TransactionItem.Date -> oldItem.date == newItem.date
                oldItem is TransactionItem.Transaction && newItem is TransactionItem.Transaction -> oldItem.name == newItem.name
                else -> false
            }
        }

        override fun areContentsTheSame(oldItem: TransactionItem, newItem: TransactionItem): Boolean {
            return oldItem == newItem
        }
    }

    sealed class TransactionItem {
        data class Transaction(val name: String) : TransactionItem()
        data class Date(val date: String) : TransactionItem()
    }
}




