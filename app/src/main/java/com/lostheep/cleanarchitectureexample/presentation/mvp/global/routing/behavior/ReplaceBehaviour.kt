package com.lostheep.cleanarchitectureexample.presentation.mvp.global.routing.behavior

import com.lostheep.cleanarchitectureexample.presentation.ui.global.BaseMvpActivity
import ru.terrakok.cicerone.commands.Command
import ru.terrakok.cicerone.commands.Replace

/**
 * Nurtelecom
 * Created by lostsheep on 19.03.18:15:32.
 */
class ReplaceBehaviour(
        private val key: String?,
        private val action: Runnable) : CommandBehaviour {

    override fun exec(from: BaseMvpActivity, command: Command): Boolean {
        if (command is Replace) {
            val sKey = command.screenKey
            if (key != null && !key.isEmpty() && key != sKey) {
                return false
            }
            from.runOnUiThread(action)
        }
        return true
    }
}