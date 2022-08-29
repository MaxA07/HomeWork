package com.example.homework.model

import com.github.javafaker.Faker

class ContactsModel {

    private var contacts = mutableListOf<Contact>()

    fun loadContacts() {
        val faker = Faker.instance()
        contacts = (1..100).map { Contact(
            id = it.toLong(),
            name = faker.name().name(),
            phone = faker.phoneNumber().phoneNumber().toString()
        ) }.toMutableList()
    }
}