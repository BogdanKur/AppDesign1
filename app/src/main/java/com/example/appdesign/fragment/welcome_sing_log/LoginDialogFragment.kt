package com.example.appdesign.fragment.welcome_sing_log

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.appdesign.R
import com.example.appdesign.databinding.FragmentLoginDialogBinding

class LoginDialogFragment : Fragment() {
    private var _binding: FragmentLoginDialogBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentLoginDialogBinding.bind(view)
        val navController = findNavController()
        binding.btnSave.setOnClickListener {
            val action = LoginDialogFragmentDirections.actionLoginDialogFragmentToLoginFragment()
            navController.navigate(action)
        }
    }


}