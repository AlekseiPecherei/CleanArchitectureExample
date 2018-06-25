package com.lostheep.cleanarchitectureexample.presentation.mvp.global.actions

import android.app.Activity

/**
 * Nurtelecom
 * Created by lostsheep on 26.04.18:10:09.
 */
class ActivityResults {
    private val behaviours = ArrayList<IResultBehaviour>()

    fun addCommand(requestCode: Int, resultCode: Int, action: () -> Unit): ActivityResults {
        addBehaviour(ResultBehaviour(requestCode, resultCode, action))
        return this
    }

    fun addCommandResultOk(requestCode: Int, action: () -> Unit): ActivityResults {
        addBehaviour(ResultBehaviour(requestCode, Activity.RESULT_OK, action))
        return this
    }

    fun addCommandResultCanceled(requestCode: Int, action: () -> Unit): ActivityResults {
        addBehaviour(ResultBehaviour(requestCode, Activity.RESULT_CANCELED, action))
        return this
    }

    fun apply(requestCode: Int, resultCode: Int) {
        for (behaviour in behaviours) {
            behaviour.exec(requestCode, resultCode)
        }
    }

    private fun addBehaviour(behaviour: IResultBehaviour) {
        behaviours.add(behaviour)
    }
}