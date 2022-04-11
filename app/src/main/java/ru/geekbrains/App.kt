package ru.geekbrains

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import com.github.terrakok.cicerone.Cicerone
import dagger.android.DaggerApplication
import ru.geekbrains.dagger.ApplicationComponent
import ru.geekbrains.dagger.DaggerApplicationComponent
import ru.geekbrains.navigation.CustomRouter

class App: Application() {

 /*   @SuppressLint("StaticFieldLeak")
    object ContextHolder { lateinit var context: Context }*/
lateinit var component: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
      //  ContextHolder.context = this
        instance = this
        component = DaggerApplicationComponent.builder()
            .setContext(this)
            .build()
    }

    /*companion object Navigation {

        private val cicerone: Cicerone<CustomRouter> by lazy {
            Cicerone.create(CustomRouter())
        }
        val navigatorHolder = cicerone.getNavigatorHolder()
        val router = cicerone.router
    }*/
    companion object{
        lateinit var instance: App
    }
}