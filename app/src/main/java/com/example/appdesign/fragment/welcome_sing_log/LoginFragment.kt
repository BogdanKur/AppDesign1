package com.example.appdesign.fragment.welcome_sing_log

import android.os.Bundle
import android.text.InputType
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.navigation.fragment.findNavController
import com.example.appdesign.R
import com.example.appdesign.databinding.FragmentLoginBinding
import com.google.android.material.textfield.TextInputEditText

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
            val action = LoginFragmentDirections.actionLoginFragmentToMainFragment()
            navController.navigate(action)
        }
        binding.btnForgotPassword.setOnClickListener {
            val action = LoginFragmentDirections.actionLoginFragmentToLoginDialogFragment()
            navController.navigate(action)
        }
        binding.btnPassVisible.setOnClickListener {
            togglePasswordVisibility(binding.btnPassVisible, binding.etPassword)
        }
    }

    private fun togglePasswordVisibility(button: ImageButton, etNewPassword: TextInputEditText) {
        if (etNewPassword.inputType == InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD) {
            etNewPassword.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
            button.setBackgroundResource(R.drawable.eye_closed)
        } else {
            etNewPassword.inputType = InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
            button.setBackgroundResource(R.drawable.open_eyes)
        }
    }
}