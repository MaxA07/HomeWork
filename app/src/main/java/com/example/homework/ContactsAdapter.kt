package com.example.homework

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.homework.databinding.ContactItemBinding

class ContactsAdapter: RecyclerView.Adapter<ContactsAdapter.ContactsViewHolder>() {

    class ContactsViewHolder(
        val binding: ContactItemBinding
    ): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactsViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ContactsViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}