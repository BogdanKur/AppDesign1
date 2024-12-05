package com.example.appdesign

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.appdesign.databinding.FragmentSupportBinding

class SupportFragment : Fragment() {
    private var _binding: FragmentSupportBinding? = null
    private val binding get() = _binding!!
    lateinit var adapter: MessageAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSupportBinding.inflate(inflater, container, false)
        val view = binding.root
        adapter = MessageAdapter(listOf("Hi, I am manager Max. How can I help you? Choose or write your inquiry. ", "Hi, I am manager Max. How can I help you? Choose or write your inquiry. "))
        binding.rvMessage.adapter = adapter
        val navController = findNavController()
        binding.bottomNavigationView.setupWithNavController(navController)

        return view
    }

    override fun onResume() {
        super.onResume()
        binding.bottomNavigationView.setSelectedItemId(R.id.supportFragment)
    }

}