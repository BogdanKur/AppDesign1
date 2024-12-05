package com.example.appdesign

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.appdesign.databinding.FragmentEarningBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class EarningFragment : Fragment() {
    private var _binding: FragmentEarningBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentEarningBinding.inflate(inflater, container, false)
        val view = binding.root
        val navController = findNavController()
        binding.bottomNavigationView.setupWithNavController(navController)

        return view
    }

    override fun onResume() {
        super.onResume()
        binding.bottomNavigationView.setSelectedItemId(R.id.earningFragment)
    }

}