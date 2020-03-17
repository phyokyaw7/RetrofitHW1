package com.p7k.retrofithomework.api


import com.p7k.retrofithomework.model.Type
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface TypeApiInterface  {
    @GET("posts")
    fun getPost(): Call<List<Type>>
}
