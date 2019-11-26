package com.example.week6_day6_githubapi.presenter

import com.example.week6_day6_githubapi.model.Repository
import com.example.week6_day6_githubapi.network.GitFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GitPresenter : GitContract.Presenter {

    private lateinit var view: GitContract.View

    private val gitFactory = GitFactory()

    override fun getRepositories() {

        gitFactory.getRepositories().enqueue(object : Callback<List<Repository>>{
            override fun onFailure(call: Call<List<Repository>>, t: Throwable) {
                view.displayError()
            }

            override fun onResponse(
                call: Call<List<Repository>>,
                response: Response<List<Repository>>
            ) {

                response.body()?.let {repositories ->
                    if(repositories.isNotEmpty()){
                        view.displayRepositories(repositories)

                    } else {
                        view.displayError()
                    }
                }

            }

        })

    }

    override fun setView(view: GitContract.View) {

        this.view = view
    }

}