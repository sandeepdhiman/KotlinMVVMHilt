package com.example.mvvmkotlinhilt.request

import com.example.mvvmkotlinhilt.User
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {
    @GET("users")
    suspend fun getUsers():Response<List<User>>
}