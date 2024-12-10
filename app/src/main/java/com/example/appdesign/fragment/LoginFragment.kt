package com.example.appdesign.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import com.example.appdesign.R
import com.example.appdesign.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentLoginBinding.bind(view)
        val navController = findNavController()

        binding.btnLogin.setOnClickListener {
            navController.navigate(R.id.action_loginFragment_to_mainFragment)
        }
        binding.btnForgotPassword.setOnClickListener {
            navController.navigate(R.id.action_loginFragment_to_loginDialogFragment)
        }
    }
}