package com.example.week6_day6_githubapi.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.week6_day6_githubapi.R
import com.example.week6_day6_githubapi.model.Repository
import com.example.week6_day6_githubapi.presenter.GitContract
import com.example.week6_day6_githubapi.presenter.GitPresenter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_repos_detail.*

class ReposDetailActivity : AppCompatActivity(), GitContract.View {

    private lateinit var gitPresenter: GitPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repos_detail)

        gitPresenter = GitPresenter()
        gitPresenter.setView(this)
        gitPresenter.getRepositories()

    }

    override fun displayRepositories(repositories: List<Repository>) {
        val index = intent.getIntExtra("index",0)
        val currentRepo = repositories.get(index)
        repoName_textView.text = "Repository name: " + currentRepo.name
        githubRepo_link.text = "Project Link: " + currentRepo.htmlUrl
        language_textView.text = "Language Used for the Project: " + currentRepo.language
        creationDate_textView.text = "Project Created on: " + currentRepo.createdAt
        lastUpdate_textView.text = "Last Update on: " + currentRepo.updatedAt
    }

    override fun displayError() {
        Toast.makeText(this, "Error", Toast.LENGTH_LONG).show()
    }
}
