package com.lostheep.cleanarchitectureexample.presentation.ui.global

import com.arellomobile.mvp.MvpAppCompatActivity
import com.lostheep.cleanarchitectureexample.ExampleApplication
import com.lostheep.cleanarchitectureexample.presentation.mvp.global.routing.navigator.BackNavigator
import ru.terrakok.cicerone.Navigator

/**
 * Nurtelecom
 * Created by lostsheep on 16.03.18:13:49.
 */

abstract class BaseMvpActivity : MvpAppCompatActivity() {

    override fun onResumeFragments() {
        super.onResumeFragments()
        ExampleApplication.navigatorHolder.setNavigator(navigator())
    }

    override fun onPause() {
        super.onPause()
        ExampleApplication.navigatorHolder.removeNavigator()
    }

    open fun navigator(): Navigator? {
        return BackNavigator(this)
    }
}
