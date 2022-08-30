package com.example.homework.model

import com.github.javafaker.Faker

class ContactsModel {

    private var contacts = mutableListOf<Contact>()

    fun loadContacts(): MutableList<Contact> {
        val faker = Faker.instance()
        contacts = (1..100).map { Contact(
            name = faker.name().name(),
            phone = faker.phoneNumber().phoneNumber().toString()
        ) }.toMutableList()
        return contacts
    }
}