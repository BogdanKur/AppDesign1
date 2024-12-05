package com.example.appdesign

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.appdesign.databinding.FragmentFAQBinding

class FAQFragment : Fragment() {
    private var _binding: FragmentFAQBinding? = null
    private val binding get() = _binding!!
    var isOpen1 = false
    var isOpen2 = false
    var isOpen3 = false
    var isOpen4 = false
    var isOpen5 = false
    var isOpen6 = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFAQBinding.inflate(inflater, container, false)
        val view = binding.root
        val navController = findNavController()
        binding.bottomNavigationView.setupWithNavController(navController)

        binding.openQuestionOne.setOnClickListener {
            isOpen1 = openQuestionAnswer(binding.openQuestionOne, binding.questionAnswer1, isOpen1)
        }
        binding.openQuestionTwo.setOnClickListener {
            isOpen2 = openQuestionAnswer(binding.openQuestionTwo, binding.questionAnswer2, isOpen2)
        }
        binding.openQuestionThree.setOnClickListener {
            isOpen3 = openQuestionAnswer(binding.openQuestionThree, binding.questionAnswer3, isOpen3)
        }
        binding.openQuestionFour.setOnClickListener {
            isOpen4 = openQuestionAnswer(binding.openQuestionFour, binding.questionAnswer4, isOpen4)
        }
        binding.openQuestionFive.setOnClickListener {
            isOpen5 = openQuestionAnswer(binding.openQuestionFive, binding.questionAnswer5, isOpen5)
        }
        binding.openQuestionSix.setOnClickListener {
            isOpen6 = openQuestionAnswer(binding.openQuestionSix, binding.questionAnswer6, isOpen6)
        }


        return view
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    fun openQuestionAnswer(button: ImageView, open: LinearLayout, isOpen: Boolean): Boolean {
        val caretDownDrawable = resources.getDrawable(R.drawable.caretdown, null)
        val caretUpDrawable = resources.getDrawable(R.drawable.caretup, null)
        if (!isOpen) {
            open.visibility = View.VISIBLE
            button.setImageDrawable(caretUpDrawable)
            return true
        } else {
            open.visibility = View.GONE
            button.setImageDrawable(caretDownDrawable)
            return false
        }
    }


    override fun onResume() {
        super.onResume()
        binding.bottomNavigationView.setSelectedItemId(R.id.faqFragment)
    }

}