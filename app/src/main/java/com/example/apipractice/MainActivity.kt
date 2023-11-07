package com.example.apipractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView:RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById<RecyclerView>(R.id.recyclerView)


        val retrofitInstance = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(ApiInterface::class.java)

       val retrofitData = retrofitInstance.getPosts()

        retrofitData.enqueue(object : Callback<UserPosts> {
            override fun onResponse(call: Call<UserPosts>, response: Response<UserPosts>) {
                val responseBody = response.body()!!
                val userpostList = responseBody
                recyclerView.adapter = UserAdapter(this@MainActivity,userpostList)



                recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
            }

            override fun onFailure(call: Call<UserPosts>, t: Throwable) {
                Toast.makeText(baseContext, "Failed to retrieve data", Toast.LENGTH_LONG).show()
            }
        })

//        Open up new Activity on clicking each item
//        recyclerView.addOnItemTouchListener(




    }
}