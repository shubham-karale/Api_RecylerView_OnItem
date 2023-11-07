package com.example.apipractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class CommentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comment)

//        Getting data from on click of each item
        val commentName = intent.getStringExtra("commentName")
        val commentEmail = intent.getStringExtra("commentEmail")
        val commentBody = intent.getStringExtra("commentBody")

//        Setting data to the views
        val commentNameView = findViewById<TextView>(R.id.commentName)
        val commentEmailView = findViewById<TextView>(R.id.commentEmail)
        val commentBodyView = findViewById<TextView>(R.id.commentBody)

//        commentNameView.text = commentName
//        commentEmailView.text = commentEmail
//        commentBodyView.text = commentBody

        commentNameView.text = "Name: $commentName"
        commentEmailView.text = "Email: $commentEmail"
        commentBodyView.text = "Body: $commentBody"



    }
}