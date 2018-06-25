package com.lostheep.cleanarchitectureexample.presentation.mvp.global.actions


/**
 * Nurtelecom
 * Created by lostsheep on 26.04.18:10:10.
 */
class ResultBehaviour(private val requestCode: Int,
                      private val resultCode: Int,
                      private val action: () -> Unit) : IResultBehaviour {

    override fun exec(requestCode: Int, resultCode: Int): Boolean {
        if (this.requestCode == requestCode && this.resultCode == resultCode) {
            action.invoke()
            return true
        }
        return false
    }
}