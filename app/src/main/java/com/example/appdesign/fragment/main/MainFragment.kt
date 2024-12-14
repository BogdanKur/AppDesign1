package com.example.appdesign.fragment.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.navigation.fragment.findNavController
import com.example.appdesign.R
import com.example.appdesign.databinding.FragmentMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainFragment : Fragment() {
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentMainBinding.bind(view)
        val navController = findNavController()
        val bottomNav: BottomNavigationView = requireActivity().findViewById(R.id.bottomNavigationViews)
        bottomNav.visibility = View.VISIBLE
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) { }
        binding.rlMedia.setOnClickListener{
            val action = MainFragmentDirections.actionMainFragmentToMediaFragment()
            navController.navigate(action)
        }
        binding.rlTask.setOnClickListener{
            val action = MainFragmentDirections.actionMainFragmentToTasksFragment()
            navController.navigate(action)
        }
        binding.rlNew.setOnClickListener{
            val action = MainFragmentDirections.actionMainFragmentToNewsFragment()
            navController.navigate(action)
        }
        binding.btnProfilePhoto.setOnClickListener {
            val action = MainFragmentDirections.actionMainFragmentToProfileFragment("main")
            navController.navigate(action)
        }
        val dataPoints = listOf(2f, 5f, 8f, 6f, 4f, 5f, 2f)
        binding.lineChartView.setData(dataPoints)
        binding.lineChartViewDown.setData(dataPoints)
    }

}