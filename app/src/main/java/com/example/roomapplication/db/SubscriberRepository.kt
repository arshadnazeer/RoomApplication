package com.example.roomapplication.db

class SubscriberRepository(private val dao:SubscriberDAO) {

    val subscribers = dao.getAllSubscribers()
    // no need to process this data on background, since Room does it automatically

    suspend fun insert(subscriber: Subscriber){
        dao.intsertSubscriber(subscriber)
    }

    suspend fun update(subscriber: Subscriber){
        dao.deleteSubscriber(subscriber)
    }

    suspend fun delete(subscriber: Subscriber){
        dao.deleteSubscriber(subscriber)
    }

    suspend fun deleteAll(){
        dao.deleteAll()
    }

}