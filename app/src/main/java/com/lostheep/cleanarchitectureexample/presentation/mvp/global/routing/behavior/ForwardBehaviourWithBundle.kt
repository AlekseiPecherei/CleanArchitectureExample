package com.lostheep.cleanarchitectureexample.presentation.mvp.global.routing.behavior

import android.content.Intent
import android.os.Bundle
import com.lostheep.cleanarchitectureexample.presentation.ui.global.BaseMvpActivity
import ru.terrakok.cicerone.commands.Command
import ru.terrakok.cicerone.commands.Forward

/**
 * Nurtelecom
 * Created by lostsheep on 30.03.18:12:14.
 */
class ForwardBehaviourWithBundle(
        private val key: String?,
        private val actTo: Class<*>) : CommandBehaviour {

    override fun exec(from: BaseMvpActivity, command: Command): Boolean {
        if (command is Forward) {
            val sKey = command.screenKey
            if (key != null && key != sKey) {
                return false
            }
            val args = command.transitionData as Bundle
            val intent = Intent(from, actTo)
            intent.putExtras(args)
            from.startActivity(intent)
        }
        return true
    }
}