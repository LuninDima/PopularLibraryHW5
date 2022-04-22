package ru.geekbrains.recycler.repos

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import ru.geekbrains.data.room.GitHubUserRepos.GitHubUserRepos
import ru.geekbrains.databinding.ViewUserBinding

class ReposAdapter(private val onReposClickListener: OnReposClickListener?): ListAdapter<GitHubUserRepos, ReposViewHolder>(
    ReposDiff()
) {

    interface OnReposClickListener {
        fun onReposPicked(repos: GitHubUserRepos)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReposViewHolder {
        val itemBinding = ViewUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ReposViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ReposViewHolder, position: Int) =
        holder.bind(getItem(position), onReposClickListener)

}