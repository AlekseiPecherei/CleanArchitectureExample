package com.lostheep.cleanarchitectureexample.presentation.mvp.global.mapping.mappers

import com.lostheep.cleanarchitectureexample.domain.album.AlbumDataModel
import com.lostheep.cleanarchitectureexample.presentation.mvp.global.mapping.uimodels.AlbumDataUIModel
import io.reactivex.functions.Function

class AlbumDataModelMapper : Function<AlbumDataModel, AlbumDataUIModel> {
    override fun apply(model: AlbumDataModel): AlbumDataUIModel {
        val builder = StringBuilder()
        for (item in model.albums) {
            builder.append(item.id)
            builder.append("    ")
            builder.append(item.title)
            builder.append("\n")
        }
        return AlbumDataUIModel(builder.toString())
    }
}