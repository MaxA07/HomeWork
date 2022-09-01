package com.example.homework

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.homework.databinding.ContactItemBinding
import com.example.homework.model.Contact
import com.example.homework.model.ContactsModel
import kotlinx.coroutines.channels.ticker

class ContactsAdapter(private val onItemClick: OnItemClick): RecyclerView.Adapter<ContactsAdapter.ContactsViewHolder>() {
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
        holder.binding.name.text = contactList[position].name
        holder.binding.phoneNumber.text = contactList[position].phone
        holder.itemView.setOnClickListener {
            onItemClick.onItemClicked(position)
        }


        with(holder.binding) {
            Glide.with(personImage.context)
                .load("https://source.unsplash.com/random/800x600")
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .circleCrop()
                .placeholder(R.drawable.image)
                .into(personImage)
        }

    }

    override fun getItemCount(): Int {
        return contactList.size
    }
}