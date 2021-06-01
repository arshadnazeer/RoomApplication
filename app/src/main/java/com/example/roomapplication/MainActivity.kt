package com.example.roomapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.roomapplication.databinding.ActivityMainBinding
import com.example.roomapplication.db.SubscriberDatabase
import com.example.roomapplication.db.SubscriberRepository

class MainActivity : AppCompatActivity() {

    private lateinit var dataBinding: ActivityMainBinding
    private lateinit var subscriberViewModel: SubscriberViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        // we need to pass the DAO instace to the factory class, hence create a DAO instance
        val dao = SubscriberDatabase.getInstance(application).subscriberDAO

        val repository = SubscriberRepository(dao)

        val factory = SubscriberViewModelFactory(repository)

        subscriberViewModel = ViewModelProvider(this,factory).get(SubscriberViewModel::class.java)

        dataBinding.myViewModel = subscriberViewModel
        dataBinding.lifecycleOwner = this

        // calling the below function from the recycler view
//        displaySubscribersList()

        initRecyclerView()
    }

    // recycler view intialised
    private fun initRecyclerView() {
        dataBinding.subsRecyclerView.layoutManager = LinearLayoutManager(this)
        displaySubscribersList()
    }

    private fun displaySubscribersList(){
        subscriberViewModel.subscribers.observe(this, Observer {
            Log.e("TAG",it.toString())
//
//            // setting the adapter by pasing list of subscribers
//            dataBinding.subsRecyclerView.adapter = MyRecyclerViewAdapter(it)
        })
    }
}