package com.example.mvvmkotlinhilt.repository

import com.example.mvvmkotlinhilt.User
import com.example.mvvmkotlinhilt.request.ApiInterface
import retrofit2.Response
import javax.inject.Inject

class Repository @Inject constructor(private val apiInterface: ApiInterface) {

    suspend fun getUserList() : Response<List<User>> = apiInterface.getUsers()
}