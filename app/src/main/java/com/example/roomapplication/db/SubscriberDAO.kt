package com.example.roomapplication.db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface SubscriberDAO {

    // alll these queries are run on a backgroung thread by default by room
    // hence no need to write coroutines/rxjava/async for this
    @Insert
    suspend fun intsertSubscriber(subscriber: Subscriber){
    }

    @Update
    suspend fun updateSubscriber(subscriber: Subscriber){
    }

    @Delete
    suspend fun deleteSubscriber(subscriber: Subscriber){
    }

    @Query("DELETE FROM subscriber_data_table")
    suspend fun deleteAll(){
    }

    // room by default return LiveData from the table

    //function to get all the list of subscribers from the table

    // no need for suspend for this method, since function returns livedata, room has already done the Job
    @Query("SELECT * FROM subscriber_data_table")
    fun getAllSubscribers():LiveData<List<Subscriber>>


}