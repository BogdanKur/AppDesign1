package com.example.appdesign.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.appdesign.adapter.MessageAdapter
import com.example.appdesign.R
import com.example.appdesign.databinding.FragmentSupportBinding

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
        adapter = MessageAdapter()
        binding.rvMessage.adapter = adapter
    }
}