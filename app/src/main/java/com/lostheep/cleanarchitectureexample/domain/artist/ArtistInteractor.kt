package com.lostheep.cleanarchitectureexample.domain.artist

import com.lostheep.cleanarchitectureexample.domain.global.BaseInteractor
import com.lostheep.cleanarchitectureexample.domain.global.models.Artist
import io.reactivex.Single
import io.reactivex.functions.Function
import io.reactivex.schedulers.Schedulers

/**
 * Nurtelecom
 * Created by lostsheep on 16.03.18:12:07.
 */

class ArtistInteractor : BaseInteractor() {

    fun loadContent(): Single<ArtistDataModel> {
        //aggregate some data source in one model with combine operators
        return repository.getArtists()
                .map(ArtistDataModel() )
                .subscribeOn(Schedulers.io())
    }
}

class ArtistDataModel : Function<List<Artist>, ArtistDataModel> {

    lateinit var artists: List<Artist>

    override fun apply(t: List<Artist>): ArtistDataModel {
        this.artists = t
        return this
    }

}

