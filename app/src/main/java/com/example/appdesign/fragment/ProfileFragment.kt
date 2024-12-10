package com.example.appdesign.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.navigation.fragment.findNavController
import com.example.appdesign.R
import com.example.appdesign.adapter.TransactionAdapter
import com.example.appdesign.databinding.FragmentProfileBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class ProfileFragment : Fragment() {
    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: TransactionAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentProfileBinding.bind(view)
        val navController = findNavController()
        val bottomNav: BottomNavigationView = requireActivity().findViewById(R.id.bottomNavigationViews)
        bottomNav.visibility = View.GONE
        adapter = TransactionAdapter()
        binding.materialButtonReferralProgram.setOnClickListener {
            navController.navigate(R.id.action_profileFragment_to_referralProgramFragment)
        }

        binding.materialButtonTransactions.setOnClickListener {
            navController.navigate(R.id.action_profileFragment_to_transactionsFragment)
        }

        binding.materialButtonWithdrawal.setOnClickListener {
            navController.navigate(R.id.action_profileFragment_to_withdrawalFragment)
        }

        binding.materialButtonProxySettings.setOnClickListener {
            navController.navigate(R.id.action_profileFragment_to_proxySettingsFragment)
        }

        binding.materialButton2.setOnClickListener {
            navController.navigate(R.id.action_profileFragment_to_mainFragment)
        }
    }
}