package ru.geekbrains.mvpuser

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.geekbrains.App
//import ru.geekbrains.App.Navigation.router
import ru.geekbrains.R
import ru.geekbrains.data.GitHubUser
import ru.geekbrains.data.GitHubUserRepositoryFactory
import ru.geekbrains.databinding.ViewUserBinding
import javax.inject.Inject

class UserFragment: MvpAppCompatFragment(R.layout.view_user), UserView {

    private lateinit var viewBinding: ViewUserBinding

    private val userLogin: String by lazy {
        arguments?.getString(ARG_USER_LOGIN).orEmpty()
    }
    private val presenter: UserPresenter by moxyPresenter {
        UserPresenter(
            userLogin = userLogin,
        ).apply {
            App.instance.component.inject(this)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding = ViewUserBinding.bind(view)
        viewBinding.userLogin.text = userLogin
    }

    override fun showUser(user: GitHubUser) {
        viewBinding.userLogin.text = user.html_url
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
}