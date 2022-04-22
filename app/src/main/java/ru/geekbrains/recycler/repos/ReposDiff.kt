package ru.geekbrains.recycler.repos

import androidx.recyclerview.widget.DiffUtil
import ru.geekbrains.data.room.GitHubUserRepos.GitHubUserRepos

class ReposDiff : DiffUtil.ItemCallback<GitHubUserRepos>() {

    override fun areItemsTheSame(oldItem: GitHubUserRepos, newItem: GitHubUserRepos): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: GitHubUserRepos, newItem: GitHubUserRepos): Boolean {
        return oldItem == newItem
    }
}