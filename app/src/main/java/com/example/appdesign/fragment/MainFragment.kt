package com.example.appdesign.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.activity.addCallback
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import androidx.navigation.ui.setupWithNavController
import com.example.appdesign.adapter.News
import com.example.appdesign.adapter.NewsAdapter
import com.example.appdesign.interfaces.NewsAdapterClickItem
import com.example.appdesign.R
import com.example.appdesign.adapter.ImageSliderAdapter
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
            navController.navigate(R.id.action_mainFragment_to_mediaFragment)
        }
        binding.rlTask.setOnClickListener{
            navController.navigate(R.id.action_mainFragment_to_tasksFragment)
        }
        binding.rlNew.setOnClickListener{
            navController.navigate(R.id.action_mainFragment_to_newsFragment)
        }
        binding.btnProfilePhoto.setOnClickListener {
            navController.navigate(R.id.action_mainFragment_to_profileFragment)
        }
    }

}