package com.example.week6_day6_githubapi.network

import com.example.week6_day6_githubapi.model.Repository
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface GitService {

    @GET("users/{username}/{dataRequest}")
    fun getUsers(@Path("username") username: String,
                 @Path("dataRequest") dataRequest: String) : Call<List<Repository>>

}