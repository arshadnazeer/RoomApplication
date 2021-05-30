package com.example.roomapplication.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

// This is pretty much a boiler code

// @DAtabase Provide the list of enity classes
@Database(entities = [Subscriber::class], version = 1)
abstract class SubscriberDatabase : RoomDatabase(){

    // Declaring an abstract ref for DAO Interface, since only 1 DAO and hence just one ref
    abstract val subscriberDAO : SubscriberDAO

    // NOw we create just one instance of this class, to avoid error and multiple issues
    // singleton object

    // In kotlin we create singleton as companion objects

    companion object{
        // volatile keyword helps to make the field immediately  visible
        @Volatile
        private var INSTANCE: SubscriberDatabase?=null

        fun getInstance(context: Context) : SubscriberDatabase{
            synchronized(this){
                var instance = INSTANCE
                if (instance==null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        SubscriberDatabase::class.java,
                        "subscriber_data_database"
                    ).build()
                }
                return instance
            }
        }
    }



}