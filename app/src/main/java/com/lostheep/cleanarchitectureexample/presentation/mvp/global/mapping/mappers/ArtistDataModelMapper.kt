package com.lostheep.cleanarchitectureexample.presentation.mvp.global.mapping.mappers

import com.lostheep.cleanarchitectureexample.domain.artist.ArtistDataModel
import com.lostheep.cleanarchitectureexample.presentation.mvp.global.mapping.uimodels.ArtistDataUIModel
import io.reactivex.functions.Function

class ArtistDataModelMapper : Function<ArtistDataModel, ArtistDataUIModel> {
    override fun apply(model: ArtistDataModel): ArtistDataUIModel {
        val builder = StringBuilder()
        for (item in model.artists) {
            builder.append(item.id)
            builder.append("    ")
            builder.append(item.title)
            builder.append("\n")
        }
        return ArtistDataUIModel(builder.toString())
    }
}