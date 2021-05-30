package com.example.roomapplication.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

// Annotate the class with @entity annotation

// give the table name, else the data class will use the default class name as atble name
@Entity(tableName = "subscriber_data_table")
class Subscriber(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="subscriber_id")
    val id: Int,

    @ColumnInfo(name="subscriber_name")
    val name: String,

    @ColumnInfo(name="subscriber_email")
    val email: String
)