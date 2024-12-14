package com.example.appdesign.fragment.settings

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.navigation.fragment.findNavController
import com.example.appdesign.R
import com.example.appdesign.databinding.FragmentLanguageBinding

class LanguageFragment : Fragment() {
    private var _binding: FragmentLanguageBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_language, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentLanguageBinding.bind(view)
        val navController = findNavController()
        binding.materialButtonCloseChooseLanguage.setOnClickListener {
            val action = LanguageFragmentDirections.actionLanguageFragmentToSettingsFragment()
            navController.navigate(action)
        }
        binding.cl1.setOnClickListener{
            currentLanguage(binding.flCurrent, binding.flCurrent2, binding.flCurrent3, binding.flCurrent4, binding.flCurrent5)
        }
        binding.cl2.setOnClickListener{
            currentLanguage(binding.flCurrent2, binding.flCurrent, binding.flCurrent3, binding.flCurrent4, binding.flCurrent5)
        }
        binding.cl3.setOnClickListener{
            currentLanguage(binding.flCurrent3, binding.flCurrent2, binding.flCurrent, binding.flCurrent4, binding.flCurrent5)
        }
        binding.cl4.setOnClickListener{
            currentLanguage(binding.flCurrent4, binding.flCurrent2, binding.flCurrent3, binding.flCurrent, binding.flCurrent5)
        }
        binding.cl5.setOnClickListener{
            currentLanguage(binding.flCurrent5, binding.flCurrent2, binding.flCurrent3, binding.flCurrent4, binding.flCurrent)
        }
    }

    fun currentLanguage(fl1: FrameLayout, fl2: FrameLayout, fl3: FrameLayout, fl4: FrameLayout, fl5: FrameLayout) {
        fl1.visibility = View.VISIBLE
        fl2.visibility = View.GONE
        fl3.visibility = View.GONE
        fl4.visibility = View.GONE
        fl5.visibility = View.GONE
    }
}