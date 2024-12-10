package com.example.appdesign.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import com.example.appdesign.R
import com.example.appdesign.databinding.FragmentSingUpBinding

class SingUpFragment : Fragment() {
    private var _binding: FragmentSingUpBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_sing_up, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentSingUpBinding.bind(view)
        val navController = findNavController()
        binding.btnRegistrate.setOnClickListener {
            navController.navigate(R.id.action_singUpFragment_to_loginFragment)
        }
        binding.btnLogin.setOnClickListener {
            navController.navigate(R.id.action_singUpFragment_to_loginFragment)
        }
    }

}