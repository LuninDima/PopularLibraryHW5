package ru.geekbrains.mvpuser

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.geekbrains.App
//import ru.geekbrains.App.Navigation.router
import ru.geekbrains.R

import ru.geekbrains.data.room.GitHubUserRepos.GitHubUserRepos

import ru.geekbrains.databinding.ViewUserReposBinding
import ru.geekbrains.recycler.repos.ReposAdapter


class UserFragment : MvpAppCompatFragment(R.layout.view_user_repos), UserView,
    ReposAdapter.OnReposClickListener {

    private lateinit var viewBinding: ViewUserReposBinding

    private val userLogin: String by lazy {
        arguments?.getString(ARG_USER_LOGIN).orEmpty()
    }
    private val presenter: UserPresenter by moxyPresenter {
        UserPresenter(
            userLogin = userLogin,
        ).apply {
            App.instance.component.providerUserRepoComponent().build().inject(this)
        }
    }
    private val reposAdapter = ReposAdapter(this)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding = ViewUserReposBinding.bind(view)
        viewBinding.reposRecycler.adapter = reposAdapter

    }


    override fun showUserRepos(repos: List<GitHubUserRepos>) {
        reposAdapter.submitList(repos)
    }

    companion object {
        const val ARG_USER_LOGIN = "arg_user_login"

        fun newInstance(userId: String): Fragment =
            UserFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_USER_LOGIN, userId)
                }
            }
    }

    override fun onReposPicked(repos: GitHubUserRepos) {
        TODO("Not yet implemented")
    }


}