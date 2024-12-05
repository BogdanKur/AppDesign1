package com.example.appdesign

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.appdesign.databinding.FragmentSettingsBinding

class SettingsFragment : Fragment() {
    private var _binding: FragmentSettingsBinding? = null
    private val binding get() = _binding!!
    lateinit var fadeOut: Animation
    lateinit var fadeIn : Animation
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSettingsBinding.inflate(inflater, container, false)
        val view = binding.root
        val navController = findNavController()
        fadeOut = AnimationUtils.loadAnimation(context, R.anim.fade_out)
        fadeIn = AnimationUtils.loadAnimation(context, R.anim.fade_in)
        binding.bottomNavigationView.setupWithNavController(navController)
        binding.switchPush.setOnClickListener {
            if(!binding.switchPush.isChecked) {
                fadeOut.setAnimationListener(object : Animation.AnimationListener {
                    override fun onAnimationStart(animation: Animation?) {
                    }

                    override fun onAnimationEnd(animation: Animation?) {
                        binding.clAllViews.visibility = View.GONE
                        binding.bottomNavigationView.visibility = View.GONE
                        binding.llConfirmAction.visibility = View.VISIBLE
                        binding.llConfirmAction.startAnimation(fadeIn)
                    }

                    override fun onAnimationRepeat(animation: Animation?) {
                    }
                })
                binding.clAllViews.startAnimation(fadeOut)
                binding.bottomNavigationView.startAnimation(fadeOut)
            }
        }
        binding.materialButtonCancel.setOnClickListener{
            fadeOut.setAnimationListener(object : Animation.AnimationListener {
                override fun onAnimationStart(animation: Animation?) {
                }

                override fun onAnimationEnd(animation: Animation?) {
                    binding.switchPush.isChecked = true
                    binding.clAllViews.visibility = View.VISIBLE
                    binding.bottomNavigationView.visibility = View.VISIBLE
                    binding.llConfirmAction.visibility = View.GONE
                    binding.clAllViews.startAnimation(fadeIn)
                    binding.bottomNavigationView.startAnimation(fadeIn)
                }

                override fun onAnimationRepeat(animation: Animation?) {
                }
            })
            binding.llConfirmAction.startAnimation(fadeOut)
        }

        binding.materialButtonTurnOff.setOnClickListener {
            fadeOut.setAnimationListener(object : Animation.AnimationListener {
                override fun onAnimationStart(animation: Animation?) {
                }

                override fun onAnimationEnd(animation: Animation?) {
                    binding.switchPush.isChecked = false
                    binding.clAllViews.visibility = View.VISIBLE
                    binding.bottomNavigationView.visibility = View.VISIBLE
                    binding.llConfirmAction.visibility = View.GONE
                    binding.clAllViews.startAnimation(fadeIn)
                    binding.bottomNavigationView.startAnimation(fadeIn)
                }

                override fun onAnimationRepeat(animation: Animation?) {
                }
            })
            binding.llConfirmAction.startAnimation(fadeOut)
        }

        binding.materialButtonEditProfile.setOnClickListener {
            fadeOut.setAnimationListener(object : Animation.AnimationListener {
                override fun onAnimationStart(animation: Animation?) {
                }

                override fun onAnimationEnd(animation: Animation?) {
                    binding.clAllViews.visibility = View.GONE
                    binding.llEditProfile.visibility = View.VISIBLE
                    binding.llEditProfile.startAnimation(fadeIn)
                }

                override fun onAnimationRepeat(animation: Animation?) {
                }
            })
            binding.clAllViews.startAnimation(fadeOut)

        }

        binding.materialButtonBackToSettings.setOnClickListener {
            fadeOut.setAnimationListener(object : Animation.AnimationListener {
                override fun onAnimationStart(animation: Animation?) {
                }

                override fun onAnimationEnd(animation: Animation?) {
                    binding.clAllViews.visibility = View.VISIBLE
                    binding.llEditProfile.visibility = View.GONE
                    binding.clAllViews.startAnimation(fadeIn)
                }

                override fun onAnimationRepeat(animation: Animation?) {
                }
            })
            binding.llEditProfile.startAnimation(fadeOut)
        }


        binding.materialButtonSaveChangeProfile.setOnClickListener {
            fadeOut.setAnimationListener(object : Animation.AnimationListener {
                override fun onAnimationStart(animation: Animation?) {
                }

                override fun onAnimationEnd(animation: Animation?) {
                    binding.clAllViews.visibility = View.VISIBLE
                    binding.llEditProfile.visibility = View.GONE
                    binding.clAllViews.startAnimation(fadeIn)
                }

                override fun onAnimationRepeat(animation: Animation?) {
                }
            })
            binding.llEditProfile.startAnimation(fadeOut)
        }

        binding.materialButtonCancelChangeProfile.setOnClickListener {
            fadeOut.setAnimationListener(object : Animation.AnimationListener {
                override fun onAnimationStart(animation: Animation?) {
                }

                override fun onAnimationEnd(animation: Animation?) {
                    binding.clAllViews.visibility = View.VISIBLE
                    binding.llEditProfile.visibility = View.GONE
                    binding.clAllViews.startAnimation(fadeIn)
                }

                override fun onAnimationRepeat(animation: Animation?) {
                }
            })
            binding.llEditProfile.startAnimation(fadeOut)
        }

        binding.materialButtonChangePassword.setOnClickListener {
            fadeOut.setAnimationListener(object : Animation.AnimationListener {
                override fun onAnimationStart(animation: Animation?) {
                }

                override fun onAnimationEnd(animation: Animation?) {
                    binding.clAllViews.visibility = View.GONE
                    binding.changePassword.visibility = View.VISIBLE
                    binding.changePassword.startAnimation(fadeIn)
                }

                override fun onAnimationRepeat(animation: Animation?) {
                }
            })
            binding.clAllViews.startAnimation(fadeOut)
        }


        binding.materialButtonBackToSettings2.setOnClickListener {
            fadeOut.setAnimationListener(object : Animation.AnimationListener {
                override fun onAnimationStart(animation: Animation?) {
                }

                override fun onAnimationEnd(animation: Animation?) {
                    binding.clAllViews.visibility = View.VISIBLE
                    binding.changePassword.visibility = View.GONE
                    binding.clAllViews.startAnimation(fadeIn)
                }

                override fun onAnimationRepeat(animation: Animation?) {
                }
            })
            binding.changePassword.startAnimation(fadeOut)
        }


        binding.btnSave.setOnClickListener {
            fadeOut.setAnimationListener(object : Animation.AnimationListener {
                override fun onAnimationStart(animation: Animation?) {
                }

                override fun onAnimationEnd(animation: Animation?) {
                    binding.clAllViews.visibility = View.VISIBLE
                    binding.changePassword.visibility = View.GONE
                    binding.clAllViews.startAnimation(fadeIn)
                }

                override fun onAnimationRepeat(animation: Animation?) {
                }
            })
            binding.changePassword.startAnimation(fadeOut)
        }

        binding.materialButtonCancelChangePassword.setOnClickListener {
            fadeOut.setAnimationListener(object : Animation.AnimationListener {
                override fun onAnimationStart(animation: Animation?) {
                }

                override fun onAnimationEnd(animation: Animation?) {
                    binding.clAllViews.visibility = View.VISIBLE
                    binding.changePassword.visibility = View.GONE
                    binding.clAllViews.startAnimation(fadeIn)
                }

                override fun onAnimationRepeat(animation: Animation?) {
                }
            })
            binding.changePassword.startAnimation(fadeOut)
        }

        binding.materialButtonLanguage.setOnClickListener {
            fadeOut.setAnimationListener(object : Animation.AnimationListener {
                override fun onAnimationStart(animation: Animation?) {
                }

                override fun onAnimationEnd(animation: Animation?) {
                    binding.clAllViews.visibility = View.GONE
                    binding.bottomNavigationView.visibility = View.GONE
                    binding.chooseLanguages.visibility = View.VISIBLE
                    binding.chooseLanguages.startAnimation(fadeIn)
                }

                override fun onAnimationRepeat(animation: Animation?) {
                }
            })
            binding.clAllViews.startAnimation(fadeOut)
            binding.bottomNavigationView.startAnimation(fadeOut)
        }
        binding.materialButtonCloseChooseLanguage.setOnClickListener {
            fadeOut.setAnimationListener(object : Animation.AnimationListener {
                override fun onAnimationStart(animation: Animation?) {
                }

                override fun onAnimationEnd(animation: Animation?) {
                    binding.clAllViews.visibility = View.VISIBLE
                    binding.bottomNavigationView.visibility = View.VISIBLE
                    binding.chooseLanguages.visibility = View.GONE
                    binding.clAllViews.startAnimation(fadeIn)
                    binding.bottomNavigationView.startAnimation(fadeIn)
                }

                override fun onAnimationRepeat(animation: Animation?) {
                }
            })
            binding.chooseLanguages.startAnimation(fadeOut)
        }

        return view
    }

    override fun onResume() {
        super.onResume()
        binding.bottomNavigationView.setSelectedItemId(R.id.settingsFragment)
    }

}