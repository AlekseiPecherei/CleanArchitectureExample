package com.lostheep.cleanarchitectureexample

import android.app.Application
import android.content.Context
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router


/**
 * Nurtelecom
 * Created by lostsheep on 16.03.18:12:18.
 */

class ExampleApplication : Application() {

    init {
        instance = this
    }


    companion object {
        private var instance: ExampleApplication? = null
        private var cicerone: Cicerone<Router>? = null


        val navigatorHolder: NavigatorHolder
            get() = cicerone!!.navigatorHolder

        val router: Router
            get() = cicerone!!.router

        val context: Context
            get() = instance!!.applicationContext
    }

    override fun onCreate() {
        super.onCreate()
        cicerone = Cicerone.create()
    }
}