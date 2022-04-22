package ru.geekbrains.recycler.repos

import androidx.recyclerview.widget.RecyclerView
import ru.geekbrains.data.room.GitHubUserRepos.GitHubUserRepos
import ru.geekbrains.databinding.ViewUserBinding
import ru.geekbrains.recycler.repos.ReposAdapter

class ReposViewHolder(private val viewBinding: ViewUserBinding): RecyclerView.ViewHolder(viewBinding.root) {

    fun bind(repos: GitHubUserRepos, onReposClickListener: ReposAdapter.OnReposClickListener?) {
        viewBinding.userLogin.text = repos.name


        viewBinding.root.setOnClickListener {
            onReposClickListener?.onReposPicked(repos)
        }
    }
}