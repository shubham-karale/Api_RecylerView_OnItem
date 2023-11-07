package com.example.apipractice

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.widget.TextView
import android.content.Intent

class UserAdapter(val context: Activity,val userpostList:List<UserPostsItem>):RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    class UserViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val commentName = itemView.findViewById<TextView>(R.id.commentName)
        val commentEmail = itemView.findViewById<TextView>(R.id.commentEmail)
        val commentBody = itemView.findViewById<TextView>(R.id.commentBody)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.each_row,parent,false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val current = userpostList[position]
        holder.commentName.text = current.title
        holder.commentEmail.text = current.id.toString()
        holder.commentBody.text = current.body

//        holder.itemView.setOnClickListener {
//            if (onClickListener != null) {
//                onClickListener!!.onClick(position, current )
//            }

        holder.itemView.setOnClickListener {
            val commentName = current.title
            val commentEmail = current.id.toString()
            val commentBody = current.body

//            Create an new Intent and sent data to that Activity
            val intent = Intent(context, CommentActivity::class.java)
            intent.putExtra("commentName", commentName)
            intent.putExtra("commentEmail", commentEmail)
            intent.putExtra("commentBody", commentBody)
            context.startActivity(intent)
        }


    }

    override fun getItemCount(): Int {
      return userpostList.size
    }


}