package com.example.appdesign.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.appdesign.R
import com.example.appdesign.databinding.FragmentReferralProgramBinding


class ReferralProgramFragment : Fragment() {
    private var _binding: FragmentReferralProgramBinding? =null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_referral_program, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentReferralProgramBinding.bind(view)
        val navController = findNavController()
        binding.materialButtonBackToSettings.setOnClickListener {
            navController.navigate(R.id.action_referralProgramFragment_to_profileFragment)
        }
    }

}