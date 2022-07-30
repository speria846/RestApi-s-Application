package com.speria.myposts

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("posts")
    fun getPost(): Call<List<Post>>
//    @GET("/posts/{id}")
//    fun getpostById(@path("id")postId:Int):Call<Post>))
}