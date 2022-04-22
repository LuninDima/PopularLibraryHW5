package ru.geekbrains.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.geekbrains.data.room.GitHubUser.GitHubUser
import ru.geekbrains.data.room.GitHubUserRepos.GitHubUserRepos
import ru.geekbrains.data.room.GitHubUser.GitHubUserDao
import ru.geekbrains.data.room.GitHubUserRepos.UserReposDao

@Database(
    exportSchema = false,
    entities = [GitHubUser::class, GitHubUserRepos::class],
    version = 2)

abstract class DBStorage: RoomDatabase() {
    abstract fun getGitHubUserDao(): GitHubUserDao
    abstract fun getGitHubUserReposDao(): UserReposDao
}