package com.lostheep.cleanarchitectureexample.presentation.mvp.artist

import com.arellomobile.mvp.MvpView
import com.lostheep.cleanarchitectureexample.presentation.mvp.global.mapping.uimodels.ArtistDataUIModel

/**
 * Nurtelecom
 * Created by lostsheep on 16.03.18:12:07.
 */

interface ArtistView : MvpView {

    fun method(model: ArtistDataUIModel)
}
