package com.example.week6_day6_githubapi.presenter

import com.example.week6_day6_githubapi.model.Repository
import retrofit2.Call

interface GitContract {

    interface Presenter {
        fun getRepositories()
        fun setView(view: View)
    }

    interface View {
        fun displayRepositories(repositories: List<Repository>)
        fun displayError()
    }

}