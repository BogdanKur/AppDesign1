package com.example.appdesign.fragment.welcome_sing_log

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.appdesign.R
import com.example.appdesign.databinding.FragmentWelcomePageBinding


class WelcomePageFragment : Fragment() {
    private var _binding: FragmentWelcomePageBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_welcome_page, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentWelcomePageBinding.bind(view)
        val navController = findNavController()
        Handler(Looper.getMainLooper()).postDelayed({
            val action = WelcomePageFragmentDirections.actionWelcomePageFragmentToSingUpFragment()
            navController.navigate(action)
        }, 2000)
    }

}