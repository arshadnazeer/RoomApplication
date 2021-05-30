package com.example.roomapplication

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.roomapplication.db.SubscriberRepository
import java.lang.IllegalArgumentException

// Since the viewmodelclass has repo constructor param even the factory shud have the repo param
class SubscriberViewModelFactory(private val repository: SubscriberRepository) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        // this is mostly a boiler plate code
        if (modelClass.isAssignableFrom(SubscriberViewModel::class.java)){
            return SubscriberViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown View Model Class")
    }

}