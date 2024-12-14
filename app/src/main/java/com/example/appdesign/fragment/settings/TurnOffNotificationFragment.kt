package com.example.appdesign.fragment.settings

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.appdesign.R
import com.example.appdesign.databinding.FragmentTurnOffNotificationBinding

class TurnOffNotificationFragment : Fragment() {
    private var _binding: FragmentTurnOffNotificationBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_turn_off_notification, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentTurnOffNotificationBinding.bind(view)
        val navController = findNavController()
        binding.materialButtonCancel.setOnClickListener {
            val action = TurnOffNotificationFragmentDirections.actionTurnOffNotificationFragmentToSettingsFragment()
            navController.navigate(action)
        }

        binding.materialButtonTurnOff.setOnClickListener {
            val bundle = Bundle().apply { putBoolean("switchOff", false) }
            val action = TurnOffNotificationFragmentDirections.actionTurnOffNotificationFragmentToSettingsFragment()
            navController.navigate(action)
        }
    }
}