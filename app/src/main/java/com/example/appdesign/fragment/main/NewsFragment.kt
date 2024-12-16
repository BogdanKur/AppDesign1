package com.example.appdesign.fragment.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.appdesign.R
import com.example.appdesign.adapter.ImageSliderAdapter
import com.example.appdesign.adapter.News
import com.example.appdesign.adapter.NewsAdapter
import com.example.appdesign.databinding.FragmentNewsBinding
import com.example.appdesign.interfaces.NewsAdapterClickItem


class NewsFragment : Fragment(), NewsAdapterClickItem {
    private var _binding: FragmentNewsBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: ImageSliderAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_news, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentNewsBinding.bind(view)
        val navController = findNavController()
        val items = listOf(
            News(R.drawable.test_image, "Text 1", "Text 2", "Text 3"),
            News(R.drawable.test_image, "Text 4", "Text 5", "Text 6"),
            News(R.drawable.test_image, "Text 1", "Text 2", "Text 3"),
            News(R.drawable.test_image, "Text 4", "Text 5", "Text 6"),
            News(R.drawable.test_image, "Text 1", "Text 2", "Text 3"),
            News(R.drawable.test_image, "Text 4", "Text 5", "Text 6"),
            News(R.drawable.test_image, "Text 1", "Text 2", "Text 3"),
            News(R.drawable.test_image, "Text 4", "Text 5", "Text 6")
        )
        val adapterNews = NewsAdapter(this)
        binding.rvRecommendation.adapter = adapterNews
        adapterNews.submitList(items)
        val images = listOf(R.drawable.test_image, R.drawable.test_image)
        adapter = ImageSliderAdapter()
        adapter.submitList(images)
        binding.viewPager.adapter = adapter
        binding.btnMainBackNew.setOnClickListener {
            val action = NewsFragmentDirections.actionNewFragmentToMainFragment()
            navController.navigate(action)
        }
    }

    override fun onButtonClick() {
        super.onButtonClick()
        val action = NewsFragmentDirections.actionNewFragmentToNewCurrentFragment()
        findNavController().navigate(action)
    }

}