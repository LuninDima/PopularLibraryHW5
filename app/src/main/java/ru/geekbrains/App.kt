package ru.geekbrains

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import com.github.terrakok.cicerone.Cicerone
import dagger.android.DaggerApplication
import ru.geekbrains.dagger.ApplicationComponent
import ru.geekbrains.dagger.DaggerApplicationComponent
import ru.geekbrains.navigation.CustomRouter

class App : Application() {

    lateinit var component: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        instance = this
        component = DaggerApplicationComponent.builder()
            .setContext(this)
            .build()
    }

    companion object {
        lateinit var instance: App
    }
}