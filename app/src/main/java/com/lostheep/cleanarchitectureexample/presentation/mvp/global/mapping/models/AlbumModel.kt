package com.lostheep.cleanarchitectureexample.presentation.mvp.global.mapping.models

/**
 * Nurtelecom
 * Created by lostsheep on 27.03.18:12:26.
 */
data class AlbumModel(
        val title: String,
        val artist: String,
        val year: String,
        val genre: String,
        val melodiesAmount: Int,
        val pictureUrl: String
)