package com.projects.roombasics

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class ContactViewModel(
    private val contactDAO: ContactDAO
): ViewModel() {

    private val _contacts = MutableLiveData<List<Contact>>()
    var contacts : LiveData<List<Contact>> = _contacts

    init {
        fetchContacts()
    }


    private fun fetchContacts(){
        viewModelScope.launch {
            _contacts.postValue(contactDAO.getContact())
        }
    }

    fun insertContact(contact: Contact) {
        viewModelScope.launch {
            contactDAO.insertContact(contact)
            fetchContacts()
        }
    }

    fun deleteContact(contact: Contact) {
        viewModelScope.launch {
            contactDAO.deleteContact(contact)
        }
    }


    fun updateContact(contact: Contact) {
        viewModelScope.launch {
            contactDAO.updateContact(contact)
        }
    }

}