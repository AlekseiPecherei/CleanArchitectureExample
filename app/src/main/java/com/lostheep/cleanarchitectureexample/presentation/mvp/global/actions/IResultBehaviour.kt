package com.lostheep.cleanarchitectureexample.presentation.mvp.global.actions

/**
 * Nurtelecom
 * Created by lostsheep on 26.04.18:11:55.
 */
interface IResultBehaviour {
    fun exec(requestCode: Int, resultCode: Int): Boolean
}