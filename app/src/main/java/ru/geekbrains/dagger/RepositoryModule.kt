package ru.geekbrains.dagger

import dagger.Module
import dagger.Provides
import ru.geekbrains.data.room.GitHubUser.GitHubUserRepository
import ru.geekbrains.data.room.GitHubUser.GitHubUserRepositoryImpl
import ru.geekbrains.data.retrofit.GitHubApi
import ru.geekbrains.data.room.DBStorage
import javax.inject.Named

@Module
class RepositoryModule {
    @Provides
    fun provideRepository(@Named("provideGitHubApi")api : GitHubApi, dbStorage: DBStorage): GitHubUserRepository {
        return GitHubUserRepositoryImpl(api, dbStorage)
    }


}