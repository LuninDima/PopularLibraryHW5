package ru.geekbrains.mvpuser

import moxy.MvpView
import moxy.viewstate.strategy.alias.SingleState
import ru.geekbrains.data.room.GitHubUserRepos.GitHubUserRepos

interface UserView : MvpView {

    /**
     * Показывает информацию о пользователе.
     * @param user пользователь
     */

    @SingleState
    fun showUserRepos(repos: List<GitHubUserRepos>)

}