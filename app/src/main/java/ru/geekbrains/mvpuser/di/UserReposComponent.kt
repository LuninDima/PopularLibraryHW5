package ru.geekbrains.mvpuser.di

import dagger.Subcomponent
import ru.geekbrains.MainActivity
import ru.geekbrains.mvpuser.UserPresenter
import javax.inject.Scope

@FragmentReposScope
@Subcomponent(
    modules = [AllDependenciesModule::class]
)
interface UserReposComponent{
    @Subcomponent.Builder
    interface Builder{
        fun build():UserReposComponent
    }
    fun inject(activity: UserPresenter)
}


@Scope
annotation class FragmentReposScope