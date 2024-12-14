package com.example.appdesign.fragment.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.appdesign.R
import com.example.appdesign.databinding.FragmentNewCurrentBinding


class NewCurrentFragment : Fragment() {
    private var _binding: FragmentNewCurrentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_new_current, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentNewCurrentBinding.bind(view)
        val navController = findNavController()
        binding.btnMainBackNewCurrent.setOnClickListener {
            val action = NewCurrentFragmentDirections.actionNewCurrentFragmentToNewFragment()
            navController.navigate(action)
        }
    }
}