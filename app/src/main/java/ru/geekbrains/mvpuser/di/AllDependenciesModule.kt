package ru.geekbrains.mvpuser.di

import dagger.Module
import dagger.Provides
import ru.geekbrains.data.retrofit.GitHubApi
import ru.geekbrains.data.room.DBStorage
import ru.geekbrains.data.room.GitHubUserRepos.GitHubUserReposRepository
import ru.geekbrains.data.room.GitHubUserRepos.GitHubUserReposRepositoryImpl
import javax.inject.Named


@Module
class AllDependenciesModule {

    @FragmentReposScope
    @Provides
    fun provideRepositoryRepos(@Named("provideGitHubApi")api : GitHubApi, dbStorage: DBStorage): GitHubUserReposRepository {
        return GitHubUserReposRepositoryImpl(api, dbStorage)
    }

}