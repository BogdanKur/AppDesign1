package com.example.appdesign

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import com.example.appdesign.databinding.FragmentLoginBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        val view = binding.root
        val navController = findNavController()
        val fadeOut = AnimationUtils.loadAnimation(context, R.anim.fade_out)
        val fadeIn = AnimationUtils.loadAnimation(context, R.anim.fade_in)
        binding.btnForgotPassword.setOnClickListener {
            fadeOut.setAnimationListener(object : Animation.AnimationListener {
                override fun onAnimationStart(animation: Animation?) {
                }

                override fun onAnimationEnd(animation: Animation?) {
                    binding.allViews.visibility = View.GONE

                    binding.changePassword.visibility = View.VISIBLE
                    binding.changePassword.startAnimation(fadeIn)
                }

                override fun onAnimationRepeat(animation: Animation?) {
                }
            })
            binding.allViews.startAnimation(fadeOut)
        }
        binding.btnSave.setOnClickListener {
            fadeOut.setAnimationListener(object : Animation.AnimationListener {
                override fun onAnimationStart(animation: Animation?) {
                }

                override fun onAnimationEnd(animation: Animation?) {
                    binding.changePassword.visibility = View.GONE

                    binding.allViews.visibility = View.VISIBLE
                    binding.allViews.startAnimation(fadeIn)
                }

                override fun onAnimationRepeat(animation: Animation?) {
                }
            })
            binding.changePassword.startAnimation(fadeOut)
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
            navController.navigate(R.id.action_loginFragment_to_mainFragment, null, navOptions)
        }

        return view
    }
}