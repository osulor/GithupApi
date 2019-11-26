package com.example.week6_day6_githubapi.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.DividerItemDecoration.VERTICAL
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.week6_day6_githubapi.R
import com.example.week6_day6_githubapi.adapter.RepositoriesAdapter
import com.example.week6_day6_githubapi.model.Repository
import com.example.week6_day6_githubapi.presenter.GitContract
import com.example.week6_day6_githubapi.presenter.GitPresenter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), GitContract.View {

    private lateinit var gitPresenter: GitPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        gitPresenter = GitPresenter()
        gitPresenter.setView(this)
        gitPresenter.getRepositories()

    }

    override fun displayError() {
        Toast.makeText(this, "Error",Toast.LENGTH_LONG).show()
    }

    override fun displayRepositories(repositories: List<Repository>) {
        username_textView.text = "Hello " + repositories.get(1).owner.login.toString() + ", here are your repositories:"
        val adapter = RepositoriesAdapter(repositories)
        repos_listView.adapter = adapter
        repos_listView.layoutManager = LinearLayoutManager(this)

        val itemDecoration = DividerItemDecoration(this,VERTICAL)
        repos_listView.addItemDecoration(itemDecoration)
    }
}
