package com.lostheep.cleanarchitectureexample.presentation.mvp.album

import com.arellomobile.mvp.MvpView
import com.lostheep.cleanarchitectureexample.presentation.mvp.global.mapping.uimodels.AlbumDataUIModel

/**
 * Nurtelecom
 * Created by lostsheep on 16.03.18:12:06.
 */

interface AlbumView : MvpView {

    fun method(model: AlbumDataUIModel)

}
