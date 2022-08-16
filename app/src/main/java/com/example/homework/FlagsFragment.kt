package com.example.homework

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.homework.databinding.FragmentFlagsBinding

class FlagsFragment : Fragment() {

    lateinit var binding: FragmentFlagsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFlagsBinding.inflate(layoutInflater, container, false)

        binding.buttonToRandom.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.mainScreen, RandomImageFragment.newInstance())
                .commit()

        }

        return binding.root
    }

    companion object {

        @JvmStatic
        fun newInstance() = FlagsFragment()
    }
}