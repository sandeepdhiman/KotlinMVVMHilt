package com.example.mvvmkotlinhilt

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_layout.view.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MainAdapter constructor(private val userList:ArrayList<User>):RecyclerView.Adapter<MainAdapter.DataViewHolder>() {

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(user: User) {
            itemView.textViewUserName.text = user.name
            itemView.textViewUserEmail.text = user.email
            Glide.with(itemView.imageViewAvatar.context)
                .load(user.avatar)
                .into(itemView.imageViewAvatar)
        }
    }
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            DataViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.item_layout, parent,
                    false
                )
            )

        override fun getItemCount(): Int = userList.size

        override fun onBindViewHolder(holder: DataViewHolder, position: Int) =
            holder.bind(userList[position])

        fun addData(list: List<User>) {
            userList.addAll(list)
        }
}