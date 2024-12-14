package com.example.appdesign.fragment.settings

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.appdesign.R
import com.example.appdesign.databinding.FragmentSettingsBinding

class SettingsFragment : Fragment() {
    private var _binding: FragmentSettingsBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_settings, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentSettingsBinding.bind(view)
        val navController = findNavController()
        arguments?.let { bundle->
            binding.switchPush.isChecked = bundle.getBoolean("switchPush") ?: true
        }
        binding.switchPush.setOnClickListener {
            if(!binding.switchPush.isChecked) {
                val action = SettingsFragmentDirections.actionSettingsFragmentToTurnOffNotificationFragment()
                navController.navigate(action)
            }
        }

        binding.materialButtonEditProfile.setOnClickListener {
            val action = SettingsFragmentDirections.actionSettingsFragmentToEditProfileFragment()
            navController.navigate(action)
        }

        binding.materialButtonChangePassword.setOnClickListener {
            val action = SettingsFragmentDirections.actionSettingsFragmentToChangePasswordFragment()
            navController.navigate(action)
        }

        binding.materialButtonLanguage.setOnClickListener {
            val action = SettingsFragmentDirections.actionSettingsFragmentToLanguageFragment()
            navController.navigate(action)
        }
        binding.btnProfilePhoto.setOnClickListener {
            val action = SettingsFragmentDirections.actionSettingsFragmentToProfileFragment()
            navController.navigate(action)
        }
    }


}