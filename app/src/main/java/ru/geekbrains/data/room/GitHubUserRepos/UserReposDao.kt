package ru.geekbrains.data.room.GitHubUserRepos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.rxjava3.core.Single
import ru.geekbrains.data.room.GitHubUserRepos.GitHubUserRepos

@Dao
interface UserReposDao {
    @Query("SELECT * FROM GithubUserReposTable")
    fun getUsersRepos(): Single<List<GitHubUserRepos>>

    @Query("SELECT * FROM GithubUserReposTable WHERE name LIKE :login Limit 1")
    fun getUserReposByName(login: String): Single<List<GitHubUserRepos>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveUserRepos(repos: List<GitHubUserRepos>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveUserRepos(repos: GitHubUserRepos)

}