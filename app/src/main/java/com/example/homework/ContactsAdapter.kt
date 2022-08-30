package com.example.homework

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.homework.databinding.ContactItemBinding
import com.example.homework.model.Contact
import com.example.homework.model.ContactsModel

class ContactsAdapter: RecyclerView.Adapter<ContactsAdapter.ContactsViewHolder>() {
    val contact = ContactsModel()
    var contactList: List<Contact> = contact.loadContacts()
        set(newValue) {
            field = newValue
            notifyDataSetChanged()
        }

    class ContactsViewHolder(
        var binding: ContactItemBinding
    ): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ContactItemBinding.inflate(inflater, parent, false)

        return ContactsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ContactsViewHolder, position: Int) {
//        val contactItem = contactList[position]
//        val item = contactItem.name
        holder.binding.name.text = contactList[position].name
        holder.binding.phoneNumber.text = contactList[position].phone
    }

    override fun getItemCount(): Int {
        return contactList.size
    }
}