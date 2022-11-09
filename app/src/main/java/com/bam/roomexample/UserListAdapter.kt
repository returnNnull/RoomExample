package com.bam.roomexample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bam.roomexample.databinding.UserItemBinding
import com.bam.roomexample.room.User

class UserListAdapter : RecyclerView.Adapter<UserListAdapter.ViewHolder>() {

    var users: List<User> = mutableListOf()


    fun updateList(users: List<User>){
        this.users = users
        notifyDataSetChanged()
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var binding: UserItemBinding = UserItemBinding.bind(view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.user_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.user = users[position]
    }

    override fun getItemCount(): Int {
        return users.size
    }


}