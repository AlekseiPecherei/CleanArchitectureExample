package com.lostheep.cleanarchitectureexample.domain.album

import com.lostheep.cleanarchitectureexample.domain.global.BaseInteractor
import com.lostheep.cleanarchitectureexample.domain.global.models.Album
import io.reactivex.Single
import io.reactivex.functions.Function
import io.reactivex.schedulers.Schedulers.io

/**
 * Nurtelecom
 * Created by lostsheep on 16.03.18:12:51.
 */

class AlbumInteractor : BaseInteractor() {

    fun loadContent(): Single<AlbumDataModel> {
        //aggregate some data source in one model with combine operators
        return repository.getAlbums()
                .map(AlbumDataModel())
                .subscribeOn(io())
    }

}

class AlbumDataModel: Function<List<Album>, AlbumDataModel> {

    lateinit var albums: List<Album>

    override fun apply(t: List<Album>): AlbumDataModel {
        this.albums = t
        return this
    }

}