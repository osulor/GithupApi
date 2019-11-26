package com.example.week6_day6_githubapi.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.week6_day6_githubapi.R
import com.example.week6_day6_githubapi.model.Repository
import com.example.week6_day6_githubapi.view.ReposDetailActivity


class RepositoriesAdapter(private val repoList: List<Repository>): RecyclerView.Adapter<RepositoriesAdapter.RespositoryViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RespositoryViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.repos_item_layout,parent,false)
        return RespositoryViewHolder(view)
    }

    override fun getItemCount(): Int {
        return repoList.size
    }

    override fun onBindViewHolder(holder: RespositoryViewHolder, position: Int) {

        val repo = repoList.get(position)
        holder.apply {
            repo_name.text = repo.name.toString()
        }

        holder.itemView.setOnClickListener {actualContext ->
            val intent = Intent(actualContext.context,ReposDetailActivity::class.java)
            intent.putExtra("index", position)
            actualContext.context.startActivity(intent)
          //  Toast.makeText(actualContext.context,repo.name,Toast.LENGTH_LONG).show()
        }
    }


    inner class RespositoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val repo_name = itemView.findViewById<TextView>(R.id.repo_textView)

    }

}