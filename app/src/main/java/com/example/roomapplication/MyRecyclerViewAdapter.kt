package com.example.roomapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.roomapplication.databinding.ListItemBinding
import com.example.roomapplication.db.Subscriber

//list of subscriber as a constructor param
class MyRecyclerViewAdapter(private  val  subscriberList: List<Subscriber>) : RecyclerView.Adapter<MyViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        // getting the instance of layout inflater
        val layoutInflater = LayoutInflater.from(parent.context)

        // getting the databinding object of the list item layout
        val binding: ListItemBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.list_item, parent, false)

        // return the instance of my view holder class passing the databinding obeject
        return MyViewHolder(binding)
    }


    // returns the total numbers items in the dataset held by adapter
    override fun getItemCount(): Int {
        return subscriberList.size
    }


    // use this below function to display data on the list item
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(subscriberList[position])
    }
}

class MyViewHolder (val listItemBinding: ListItemBinding): RecyclerView.ViewHolder(listItemBinding.root){

    // binding views to each list item, passing subscriber,
    // since subscribe instace as a pram,
    fun bind(subscriber: Subscriber){

        listItemBinding.nameTextView.text = subscriber.name
        listItemBinding.emailTextView.text = subscriber.email
    }
}