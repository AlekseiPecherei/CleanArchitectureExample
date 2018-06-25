package com.lostheep.cleanarchitectureexample.presentation.mvp.global.routing.navigator

import com.lostheep.cleanarchitectureexample.presentation.ui.global.BaseMvpActivity


/**
 * Nurtelecom
 * Created by lostsheep on 19.03.18:16:16.
 */

class BackNavigator(act: BaseMvpActivity) : NavigatorExt(act) {
    init {
        addBack()
    }
}
