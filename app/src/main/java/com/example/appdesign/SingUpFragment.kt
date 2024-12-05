package com.example.appdesign

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import com.example.appdesign.databinding.FragmentSingUpBinding

class SingUpFragment : Fragment() {
    private var _binding: FragmentSingUpBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSingUpBinding.inflate(inflater, container, false)
        val view = binding.root
        val navController = findNavController()
        binding.btnRegistrate.setOnClickListener {
            val navOptions = navOptions {
                anim {
                    enter = R.anim.fade_in
                    exit = R.anim.fade_out
                    popEnter = R.anim.fade_in
                    popExit = R.anim.fade_out
                }
            }
            navController.navigate(R.id.action_singUpFragment_to_loginFragment, null, navOptions)
        }
        binding.btnLogin.setOnClickListener {
            val navOptions = navOptions {
                anim {
                    enter = R.anim.fade_in
                    exit = R.anim.fade_out
                    popEnter = R.anim.fade_in
                    popExit = R.anim.fade_out
                }
            }
            navController.navigate(R.id.action_singUpFragment_to_loginFragment, null, navOptions)
        }

        return view
    }

}