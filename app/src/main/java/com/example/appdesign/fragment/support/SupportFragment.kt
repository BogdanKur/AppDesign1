package com.example.appdesign.fragment.support

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.appdesign.adapter.MessageAdapter
import com.example.appdesign.R
import com.example.appdesign.adapter.Message
import com.example.appdesign.databinding.FragmentSupportBinding
import com.example.appdesign.fragment.earning.EarningFragmentDirections

class SupportFragment : Fragment() {
    private var _binding: FragmentSupportBinding? = null
    private val binding get() = _binding!!
    lateinit var adapter: MessageAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_support, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentSupportBinding.bind(view)
        val navController = findNavController()
        adapter = MessageAdapter()
        binding.rvMessage.adapter = adapter
        val messages = listOf(
            Message.BotMessage("Hello, how can I help you?"),
            Message.YourMessage("I need some help with my account."),
            Message.BotMessage("Sure, I'd be happy to help!")
        )

        adapter.submitList(messages)

        binding.btnProfilePhoto.setOnClickListener {
            val action = SupportFragmentDirections.actionSupportFragmentToProfileFragment()
            navController.navigate(action)
        }
    }
}