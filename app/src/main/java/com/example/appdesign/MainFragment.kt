package com.example.appdesign

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.activity.addCallback
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import androidx.navigation.ui.setupWithNavController
import com.example.appdesign.databinding.FragmentMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainFragment : Fragment(), NewsAdapterClickItem {
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: ImageSliderAdapter
    lateinit var fadeOut: Animation
    lateinit var fadeIn : Animation
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        val view = binding.root
        val navController = findNavController()
        fadeOut = AnimationUtils.loadAnimation(context, R.anim.fade_out)
        fadeIn = AnimationUtils.loadAnimation(context, R.anim.fade_in)
        binding.bottomNavigationView.setupWithNavController(navController)
        val items = listOf(
            News(R.drawable.test_image, "Text 1", "Text 2", "Text 3"),
            News(R.drawable.test_image, "Text 4", "Text 5", "Text 6"),
            News(R.drawable.test_image, "Text 7", "Text 8", "Text 9")
        )
        val adapterNews = NewsAdapter(items, this)
        binding.rvRecommendation.adapter = adapterNews
        val images = listOf(R.drawable.test_image, R.drawable.test_image)
        adapter = ImageSliderAdapter(images)
        binding.viewPager.adapter = adapter
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) { }
        binding.rlMedia.setOnClickListener{
            fadeOut.setAnimationListener(object : Animation.AnimationListener {
                override fun onAnimationStart(animation: Animation?) {
                }

                override fun onAnimationEnd(animation: Animation?) {
                    binding.constraintFirst.visibility = View.GONE
                    binding.constraintSecond.visibility = View.GONE
                    binding.clMedia.visibility = View.VISIBLE
                    binding.clMedia.startAnimation(fadeIn)
                }

                override fun onAnimationRepeat(animation: Animation?) {
                }
            })
            binding.constraintFirst.startAnimation(fadeOut)
            binding.constraintSecond.startAnimation(fadeOut)
        }

        binding.btnMainBack.setOnClickListener{
            fadeOut.setAnimationListener(object : Animation.AnimationListener {
                override fun onAnimationStart(animation: Animation?) {
                }

                override fun onAnimationEnd(animation: Animation?) {
                    binding.constraintFirst.visibility = View.VISIBLE
                    binding.constraintSecond.visibility = View.VISIBLE
                    binding.clMedia.visibility = View.GONE
                    binding.constraintFirst.startAnimation(fadeIn)
                    binding.constraintSecond.startAnimation(fadeIn)
                }

                override fun onAnimationRepeat(animation: Animation?) {
                }
            })
            binding.clMedia.startAnimation(fadeOut)
        }

        binding.rlTask.setOnClickListener{
            fadeOut.setAnimationListener(object : Animation.AnimationListener {
                override fun onAnimationStart(animation: Animation?) {
                }

                override fun onAnimationEnd(animation: Animation?) {
                    binding.constraintFirst.visibility = View.GONE
                    binding.constraintSecond.visibility = View.GONE
                    binding.clTasks.visibility = View.VISIBLE
                    binding.clTasks.startAnimation(fadeIn)
                }

                override fun onAnimationRepeat(animation: Animation?) {
                }
            })
            binding.constraintFirst.startAnimation(fadeOut)
            binding.constraintSecond.startAnimation(fadeOut)
        }

        binding.btnMainBackTask.setOnClickListener{
            fadeOut.setAnimationListener(object : Animation.AnimationListener {
                override fun onAnimationStart(animation: Animation?) {
                }

                override fun onAnimationEnd(animation: Animation?) {
                    binding.constraintFirst.visibility = View.VISIBLE
                    binding.constraintSecond.visibility = View.VISIBLE
                    binding.clTasks.visibility = View.GONE
                    binding.constraintFirst.startAnimation(fadeIn)
                    binding.constraintSecond.startAnimation(fadeIn)
                }

                override fun onAnimationRepeat(animation: Animation?) {
                }
            })
            binding.clTasks.startAnimation(fadeOut)
        }

        binding.rlNew.setOnClickListener{
            fadeOut.setAnimationListener(object : Animation.AnimationListener {
                override fun onAnimationStart(animation: Animation?) {
                }

                override fun onAnimationEnd(animation: Animation?) {
                    binding.constraintFirst.visibility = View.GONE
                    binding.constraintSecond.visibility = View.GONE
                    binding.clNew.visibility = View.VISIBLE
                    binding.clNew.startAnimation(fadeIn)
                }

                override fun onAnimationRepeat(animation: Animation?) {
                }
            })
            binding.constraintFirst.startAnimation(fadeOut)
            binding.constraintSecond.startAnimation(fadeOut)
        }

        binding.btnMainBackNew.setOnClickListener{
            fadeOut.setAnimationListener(object : Animation.AnimationListener {
                override fun onAnimationStart(animation: Animation?) {
                }

                override fun onAnimationEnd(animation: Animation?) {
                    binding.constraintFirst.visibility = View.VISIBLE
                    binding.constraintSecond.visibility = View.VISIBLE
                    binding.clNew.visibility = View.GONE
                    binding.constraintFirst.startAnimation(fadeIn)
                    binding.constraintSecond.startAnimation(fadeIn)
                }

                override fun onAnimationRepeat(animation: Animation?) {
                }
            })
            binding.clNew.startAnimation(fadeOut)
        }

        binding.btnMainBackNewCurrent.setOnClickListener{
            fadeOut.setAnimationListener(object : Animation.AnimationListener {
                override fun onAnimationStart(animation: Animation?) {
                }

                override fun onAnimationEnd(animation: Animation?) {
                    binding.ivNewCurrent.visibility = View.GONE
                    binding.clNewCurrent.visibility = View.GONE
                    binding.clNew.visibility = View.VISIBLE
                    binding.clNew.startAnimation(fadeIn)
                }

                override fun onAnimationRepeat(animation: Animation?) {
                }
            })
            binding.clNewCurrent.startAnimation(fadeOut)
        }

        return view
    }

    override fun onButtonClick() {
        super.onButtonClick()
        fadeOut.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {
            }

            override fun onAnimationEnd(animation: Animation?) {
                binding.clNew.visibility = View.GONE
                binding.ivNewCurrent.visibility = View.VISIBLE
                binding.clNewCurrent.visibility = View.VISIBLE
                binding.clNewCurrent.startAnimation(fadeIn)
            }

            override fun onAnimationRepeat(animation: Animation?) {
            }
        })
        binding.clNew.startAnimation(fadeOut)
    }

    override fun onResume() {
        super.onResume()
        binding.bottomNavigationView.setSelectedItemId(R.id.mainFragment)
    }

}