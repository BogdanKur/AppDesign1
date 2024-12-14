package com.example.appdesign.fragment.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
            val action = ProfileFragmentDirections.actionProfileFragmentToReferralProgramFragment()
            navController.navigate(action)
        }

        binding.materialButtonTransactions.setOnClickListener {
            val action = ProfileFragmentDirections.actionProfileFragmentToTransactionsFragment()
            navController.navigate(action)
        }

        binding.materialButtonWithdrawal.setOnClickListener {
            val action = ProfileFragmentDirections.actionProfileFragmentToWithdrawalFragment()
            navController.navigate(action)
        }

        binding.materialButtonProxySettings.setOnClickListener {
            val action = ProfileFragmentDirections.actionProfileFragmentToProxySettingsFragment()
            navController.navigate(action)
        }

        binding.materialButton2.setOnClickListener {
            val action = ProfileFragmentDirections.actionProfileFragmentToMainFragment()
            navController.navigate(action)
        }
    }
}