package ru.geekbrains.data.room.GitHubUser

import io.reactivex.rxjava3.core.Single
import ru.geekbrains.data.room.GitHubUser.GitHubUser

interface GitHubUserRepository {

    fun getUsers(): Single<List<GitHubUser>>

    fun getUserByLogin(userId: String): Single<GitHubUser>


}