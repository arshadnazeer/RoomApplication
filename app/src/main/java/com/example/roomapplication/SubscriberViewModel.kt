package com.example.roomapplication

import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roomapplication.db.Subscriber
import com.example.roomapplication.db.SubscriberRepository
import kotlinx.coroutines.launch

// to use functions in the repository class, we need to have a reference of the repository class
class SubscriberViewModel(private val repository: SubscriberRepository) : ViewModel(), Observable {

    // getting the list of all the subscribers tha is already converted in livedata by room
    val subscribers = repository.subscribers


    @Bindable
    val inputName = MutableLiveData<String?>()
    @Bindable
    val inputEmail = MutableLiveData<String?>()

    // changing button text dynamically
    @Bindable
    val saveorupdatebutton = MutableLiveData<String>()
    @Bindable
    val clearordeletebutton = MutableLiveData<String>()

    init {
        saveorupdatebutton.value = "Save"
        clearordeletebutton.value = "Clear All"
    }

    fun onSaveOrUpdateButton(){
        val name = inputName.value!!
        val email = inputEmail.value!!

        insert(Subscriber(0,name,email))

        inputName.value = null
        inputEmail.value = null

    }

    fun onClearOrDeleteButton(){
        clearAll()
    }


    // from here we can call the instance of repository function passing an subscriber instance
    // doing the call through a background thread using viewmodelscope
    fun insert(subscriber: Subscriber) = viewModelScope.launch {
            repository.insert(subscriber)
        }

    fun update(subscriber: Subscriber) = viewModelScope.launch {
        repository.update(subscriber)
    }

    fun delete(subscriber: Subscriber) = viewModelScope.launch {
        repository.delete(subscriber)
    }

    fun clearAll() = viewModelScope.launch {
        repository.deleteAll()
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }

}