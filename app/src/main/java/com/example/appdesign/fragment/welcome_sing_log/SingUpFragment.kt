package com.example.appdesign.fragment.welcome_sing_log

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
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
            val action = SingUpFragmentDirections.actionSingUpFragmentToLoginFragment()
            navController.navigate(action)
        }
        binding.btnLogin.setOnClickListener {
            val action = SingUpFragmentDirections.actionSingUpFragmentToLoginFragment()
            navController.navigate(action)
        }
    }

}