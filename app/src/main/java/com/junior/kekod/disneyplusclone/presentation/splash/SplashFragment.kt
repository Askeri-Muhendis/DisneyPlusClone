package com.junior.kekod.disneyplusclone.presentation.splash

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import com.junior.kekod.disneyplusclone.R
import com.junior.kekod.disneyplusclone.databinding.FragmentSplashBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SplashFragment : Fragment() {
    private var _binding : FragmentSplashBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSplashBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleScope.launch{
            delay(3000)
            val action = SplashFragmentDirections.actionSplashFragmentToOnBoardingFragment()
            requireView().findNavController().navigate(action)
        }
        val window = requireActivity().window
        window.navigationBarColor = ContextCompat.getColor(requireContext(),R.color.navigation_bar_color)
        window.statusBarColor = ContextCompat.getColor(requireContext(),R.color.status_bar_color)
    }

    // Memory Leak
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}