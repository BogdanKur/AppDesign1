package com.example.appdesign.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.appdesign.R
import com.example.appdesign.databinding.FragmentChangePasswordBinding

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
            navController.navigate(R.id.action_changePasswordFragment_to_settingsFragment)
        }
        binding.btnSave.setOnClickListener {
            navController.navigate(R.id.action_changePasswordFragment_to_settingsFragment)
        }
        binding.materialButtonCancelChangePassword.setOnClickListener {
            navController.navigate(R.id.action_changePasswordFragment_to_settingsFragment)
        }
    }

}