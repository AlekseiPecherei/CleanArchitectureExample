package com.lostheep.cleanarchitectureexample.presentation.mvp.album

import com.arellomobile.mvp.InjectViewState
import com.lostheep.cleanarchitectureexample.domain.album.AlbumDataModel
import com.lostheep.cleanarchitectureexample.domain.album.AlbumInteractor
import com.lostheep.cleanarchitectureexample.presentation.mvp.global.AbsPresenter
import com.lostheep.cleanarchitectureexample.presentation.mvp.global.mapping.mappers.AlbumDataModelMapper
import com.lostheep.cleanarchitectureexample.presentation.mvp.global.routing.RouterConstants
import io.reactivex.android.schedulers.AndroidSchedulers

/**
 * Nurtelecom
 * Created by lostsheep on 16.03.18:12:06.
 */

@InjectViewState
class AlbumPresenter : AbsPresenter<AlbumView>() {

    private val interactor = AlbumInteractor()
    private var content: AlbumDataModel? = null

    init {
        interactor.loadContent()
                .observeOn(AndroidSchedulers.mainThread())
                .map { model ->
                    content = model
                    return@map model
                }
                .map(AlbumDataModelMapper())
                .subscribe({
                    viewState.method(it)
                }, {

                })
    }

    fun open() {
        router.navigateTo(RouterConstants.ARTIST)
    }

}
