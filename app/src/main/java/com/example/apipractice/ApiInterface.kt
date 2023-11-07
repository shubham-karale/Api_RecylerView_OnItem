package com.example.apipractice

import retrofit2.http.GET

import retrofit2.Call

interface ApiInterface {

    @GET("posts")
    fun getPosts(): Call<UserPosts>

}