package ru.geekbrains.data.room.GitHubUserRepos

import io.reactivex.rxjava3.core.Single

interface GitHubUserReposRepository {

    fun getUsersRepos(): Single<List<GitHubUserRepos>>

    fun getUserReposByName(login: String): Single<List<GitHubUserRepos>>
}