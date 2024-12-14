package com.example.appdesign.fragment.earning

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.appdesign.R
import com.example.appdesign.databinding.FragmentEarningBinding
import com.example.appdesign.fragment.main.MainFragmentDirections
import com.google.android.material.bottomnavigation.BottomNavigationView

class EarningFragment : Fragment() {
    private var _binding: FragmentEarningBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_earning, container , false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentEarningBinding.bind(view)
        val navController = findNavController()
        val bottomNav: BottomNavigationView = requireActivity().findViewById(R.id.bottomNavigationViews)
        bottomNav.visibility = View.VISIBLE
        binding.btnProfilePhoto.setOnClickListener {
            val action = EarningFragmentDirections.actionEarningFragmentToProfileFragment("earn")
            navController.navigate(action)
        }
    }

}