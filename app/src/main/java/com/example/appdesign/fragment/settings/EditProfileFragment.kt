package com.example.appdesign.fragment.settings

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.appdesign.R
import com.example.appdesign.databinding.FragmentEditProfileBinding

class EditProfileFragment : Fragment() {
    private var _binding: FragmentEditProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_edit_profile, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentEditProfileBinding.bind(view)
        val navController = findNavController()
        binding.materialButtonBackToSettings.setOnClickListener {
            val action = EditProfileFragmentDirections.actionEditProfileFragmentToSettingsFragment()
            navController.navigate(action)
        }
        binding.materialButtonSaveChangeProfile.setOnClickListener {
            val action = EditProfileFragmentDirections.actionEditProfileFragmentToSettingsFragment()
            navController.navigate(action)
        }
        binding.materialButtonCancelChangeProfile.setOnClickListener {
            val action = EditProfileFragmentDirections.actionEditProfileFragmentToSettingsFragment()
            navController.navigate(action)
        }
    }

}