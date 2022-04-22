package ru.geekbrains.mvpuser

import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.MvpPresenter
import ru.geekbrains.data.room.GitHubUser.GitHubUserRepository
import ru.geekbrains.data.room.GitHubUserRepos.GitHubUserReposRepository
import javax.inject.Inject

class UserPresenter(
    private val userLogin: String): MvpPresenter<UserView>() {

    @Inject
    lateinit var userRepository: GitHubUserRepository
    @Inject
    lateinit var userReposRepository: GitHubUserReposRepository
    @Inject
    lateinit var router: Router

    override fun onFirstViewAttach() {


        userReposRepository.getUserReposByName(userLogin)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
               // viewState.showUser(it)
                viewState.showUserRepos(it)
            },{
                val errorMessage = it.message
                //DisplayError
            })

    }
}