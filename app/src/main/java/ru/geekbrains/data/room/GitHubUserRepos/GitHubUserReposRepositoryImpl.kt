package ru.geekbrains.data.room.GitHubUserRepos

import io.reactivex.rxjava3.core.Single
import ru.geekbrains.data.retrofit.GitHubApi
import ru.geekbrains.data.room.DBStorage
import javax.inject.Inject

class GitHubUserReposRepositoryImpl
    @Inject constructor(
    private val gitHubApi: GitHubApi,
    private val roomDb: DBStorage

): GitHubUserReposRepository {
    override fun getUserReposByName(login: String): Single<List<GitHubUserRepos>> {
        return roomDb.getGitHubUserReposDao().getUsersRepos()
            .flatMap {
                gitHubApi.fetchUserRepositories(login)
                    .map { resultFromServer ->
                        roomDb.getGitHubUserReposDao().saveUserRepos(resultFromServer)
                        resultFromServer
                    }

            }
    }
    override fun getUsersRepos(): Single<List<GitHubUserRepos>> {
        TODO("Not yet implemented")
    }
}