package com.example.soccerappmotasemesaefan.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.soccerappmotasemesaefan.R
import com.example.soccerappmotasemesaefan.databinding.HomeFragmentBinding

class HomeFragment : Fragment() {
    private var _binding : HomeFragmentBinding? = null
    private val binding : HomeFragmentBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = HomeFragmentBinding.inflate(layoutInflater)

        binding.imButtonHome.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, SoccerListFragment.newInstance())
                .addToBackStack(null)
                .commit()
        }


        return binding.root
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}