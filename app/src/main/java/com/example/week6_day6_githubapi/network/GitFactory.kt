package com.example.week6_day6_githubapi.network

import com.example.week6_day6_githubapi.model.Repository
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class GitFactory {

   private val BASE_URL = "https://api.github.com"

    private var gitService: GitService

    init {
        gitService = createService(getRetrofitInstance())
    }

    private fun getRetrofitInstance(): Retrofit{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun createService(retrofit: Retrofit): GitService{
        return retrofit.create(GitService::class.java)
    }

    fun getRepositories(): Call<List<Repository>>{
        return gitService.getUsers("osulor","repos")
    }

}
