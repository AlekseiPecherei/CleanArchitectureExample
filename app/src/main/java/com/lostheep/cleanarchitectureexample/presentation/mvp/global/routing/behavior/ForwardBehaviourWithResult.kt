package com.lostheep.cleanarchitectureexample.presentation.mvp.global.routing.behavior

import android.content.Intent
import com.lostheep.cleanarchitectureexample.presentation.ui.global.BaseMvpActivity
import ru.terrakok.cicerone.commands.Command
import ru.terrakok.cicerone.commands.Forward

/**
 * Nurtelecom
 * Created by lostsheep on 09.04.18:11:21.
 */
class ForwardBehaviourWithResult(
        private val key: String?,
        private val actTo: Class<*>) : CommandBehaviour {

    override fun exec(from: BaseMvpActivity, command: Command): Boolean {
        if (command is Forward) {
            val sKey = command.screenKey
            if (key != null && key != sKey) {
                return false
            }
            val intent = Intent(from, actTo)
            val requestCode = command.transitionData as Int
            from.startActivityForResult(intent, requestCode)
        }
        return true
    }
}