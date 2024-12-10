package com.example.appdesign.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.appdesign.R
import com.example.appdesign.databinding.FragmentWithdrawalBinding

class WithdrawalFragment : Fragment() {
    private var _binding: FragmentWithdrawalBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_withdrawal, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentWithdrawalBinding.bind(view)
        val navController = findNavController()
        binding.materialButtonBackToProfileWithdrawal.setOnClickListener {
            navController.navigate(R.id.action_withdrawalFragment_to_profileFragment)
        }
    }

}