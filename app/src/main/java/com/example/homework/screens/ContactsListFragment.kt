package com.example.homework.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.homework.ContactsAdapter
import com.example.homework.R
import com.example.homework.databinding.ContactItemBinding
import com.example.homework.databinding.FragmentContacrsListBinding

class ContactsListFragment : Fragment() {

    lateinit var binding: FragmentContacrsListBinding
    private val adapter by lazy { ContactsAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentContacrsListBinding.inflate(inflater, container, false)

        setupRecyclerView()

        return binding.root
    }

    private fun setupRecyclerView() {
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())


        }

    companion object {

        @JvmStatic
        fun newInstance() = ContactsListFragment()

    }
}