package com.example.homework.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.homework.R
import com.example.homework.databinding.FragmentContactDetailsBinding


class ContactDetailsFragment : Fragment() {

    lateinit var binding: FragmentContactDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentContactDetailsBinding.inflate(layoutInflater, container, false)


        return binding.root
    }

    companion object {

        @JvmStatic
        fun newInstance() = ContactDetailsFragment()
    }
}