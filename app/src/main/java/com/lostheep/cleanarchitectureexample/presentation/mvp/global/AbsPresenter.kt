package com.lostheep.cleanarchitectureexample.presentation.mvp.global

import android.content.Intent
import com.arellomobile.mvp.MvpPresenter
import com.arellomobile.mvp.MvpView
import com.lostheep.cleanarchitectureexample.ExampleApplication
import com.lostheep.cleanarchitectureexample.presentation.mvp.global.actions.ActivityResults

/**
 * Nurtelecom
 * Created by lostsheep on 19.03.18:14:07.
 */


abstract class AbsPresenter<V : MvpView> : MvpPresenter<V>() {

    protected var router = ExampleApplication.router
    protected var resourcesManager = AndroidResourceManager(ExampleApplication.context)

    protected var results = ActivityResults()

    fun back() {
        router.exit()
    }

    open fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        results.apply(requestCode, resultCode)
    }
}