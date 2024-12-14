package com.example.appdesign.fragment.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.appdesign.R
import com.example.appdesign.databinding.FragmentProxySettingsBinding

class ProxySettingsFragment : Fragment() {
    private var _binding: FragmentProxySettingsBinding? =null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_proxy_settings, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentProxySettingsBinding.bind(view)
        val navController = findNavController()
        binding.materialButtonBackToProfileSettings.setOnClickListener {
            val action = ProxySettingsFragmentDirections.actionProxySettingsFragmentToProfileFragment()
            navController.navigate(action)
        }
    }
}