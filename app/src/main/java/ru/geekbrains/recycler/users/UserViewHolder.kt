package ru.geekbrains.recycler.users

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ru.geekbrains.data.room.GitHubUser.GitHubUser
import ru.geekbrains.databinding.ViewUserBinding
import ru.geekbrains.recycler.users.UsersAdapter

class UserViewHolder(private val viewBinding: ViewUserBinding): RecyclerView.ViewHolder(viewBinding.root) {

    fun bind(user: GitHubUser, onUserClickListener: UsersAdapter.OnUserClickListener?) {
        viewBinding.userLogin.text = user.login

        Glide.with(viewBinding.userAvatar.context)
            .load(user.avatarUrl)
            .into(viewBinding.userAvatar)

        viewBinding.root.setOnClickListener {
            onUserClickListener?.onUserPicked(user)
        }
    }
}