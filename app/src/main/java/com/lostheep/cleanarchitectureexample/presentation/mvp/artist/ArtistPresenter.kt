package com.lostheep.cleanarchitectureexample.presentation.mvp.artist

import com.arellomobile.mvp.InjectViewState
import com.lostheep.cleanarchitectureexample.domain.artist.ArtistDataModel
import com.lostheep.cleanarchitectureexample.domain.artist.ArtistInteractor
import com.lostheep.cleanarchitectureexample.presentation.mvp.global.AbsPresenter
import com.lostheep.cleanarchitectureexample.presentation.mvp.global.mapping.mappers.ArtistDataModelMapper
import io.reactivex.android.schedulers.AndroidSchedulers

/**
 * Nurtelecom
 * Created by lostsheep on 16.03.18:12:07.
 */

@InjectViewState
class ArtistPresenter : AbsPresenter<ArtistView>() {
    private val interactor = ArtistInteractor()
    private var content: ArtistDataModel? = null

    init {
        interactor.loadContent()
                .observeOn(AndroidSchedulers.mainThread())
                .map { model ->
                    content = model
                    return@map model
                }
                .map(ArtistDataModelMapper())
                .subscribe({
                    viewState.method(it)
                }, {

                })
    }
}
