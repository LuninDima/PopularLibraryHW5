package ru.geekbrains.dagger

import dagger.Module
import ru.geekbrains.mvpuser.di.UserReposComponent

@Module(subcomponents = [UserReposComponent::class])
class AppModule() {
}
