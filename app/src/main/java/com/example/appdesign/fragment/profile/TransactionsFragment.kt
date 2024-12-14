package com.example.appdesign.fragment.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.appdesign.R
import com.example.appdesign.adapter.TransactionAdapter
import com.example.appdesign.databinding.FragmentTransactionsBinding


class TransactionsFragment : Fragment() {
    private var _binding: FragmentTransactionsBinding? = null
    private val binding get() = _binding!!
    lateinit var adapter: TransactionAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_transactions, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentTransactionsBinding.bind(view)
        val navController = findNavController()
        binding.materialButtonBackToProfileTransactions.setOnClickListener {
            val action = TransactionsFragmentDirections.actionTransactionsFragmentToProfileFragment()
            navController.navigate(action)
        }
        val items = listOf(
            TransactionAdapter.TransactionItem.Date("2023-10-01"),
            TransactionAdapter.TransactionItem.Transaction("Transaction 1"),
            TransactionAdapter.TransactionItem.Date("2023-10-02"),
            TransactionAdapter.TransactionItem.Transaction("Transaction 2")
        )
        adapter = TransactionAdapter()
        binding.rvTransactions.adapter = adapter
        adapter.submitList(items)
    }
}