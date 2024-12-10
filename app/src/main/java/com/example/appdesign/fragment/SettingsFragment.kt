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
import androidx.navigation.ui.setupWithNavController
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
                navController.navigate(R.id.action_settingsFragment_to_turnOffNotificationFragment)
            }
        }

        binding.materialButtonEditProfile.setOnClickListener {
            navController.navigate(R.id.action_settingsFragment_to_editProfileFragment)
        }

        binding.materialButtonChangePassword.setOnClickListener {
            navController.navigate(R.id.action_settingsFragment_to_changePasswordFragment)
        }

        binding.materialButtonLanguage.setOnClickListener {
            navController.navigate(R.id.action_settingsFragment_to_languageFragment)
        }
        binding.btnProfilePhoto.setOnClickListener {
            val navOptions = navOptions {
                anim {
                    enter = R.anim.fade_in
                    exit = R.anim.fade_out
                    popEnter = R.anim.fade_in
                    popExit = R.anim.fade_out
                }
            }
            navController.navigate(R.id.action_settingsFragment_to_profileFragment, null, navOptions)
        }
    }


}