package com.example.appdesign.fragment.settings

import android.os.Bundle
import android.text.InputType
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.navigation.fragment.findNavController
import com.example.appdesign.R
import com.example.appdesign.databinding.FragmentChangePasswordBinding
import com.google.android.material.textfield.TextInputEditText

class ChangePasswordFragment : Fragment() {
    private var _binding: FragmentChangePasswordBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_change_password, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentChangePasswordBinding.bind(view)

        val navController = findNavController()
        binding.materialButtonBackToSettings.setOnClickListener {
            val action = ChangePasswordFragmentDirections.actionChangePasswordFragmentToSettingsFragment()
            navController.navigate(action)
        }

        binding.btnSave.setOnClickListener {
            val action = ChangePasswordFragmentDirections.actionChangePasswordFragmentToSettingsFragment()
            navController.navigate(action)
        }

        binding.materialButtonCancelChangePassword.setOnClickListener {
            val action = ChangePasswordFragmentDirections.actionChangePasswordFragmentToSettingsFragment()
            navController.navigate(action)
        }

        binding.btnNewPassEnter.setOnClickListener {
            togglePasswordVisibility(binding.btnNewPassEnter, binding.etNewPassword)
        }
        binding.btnNewPassRepeat.setOnClickListener {
            togglePasswordVisibility(binding.btnNewPassRepeat, binding.etRepeatPassword)
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