package com.lostheep.cleanarchitectureexample.presentation.mvp.global.routing.behavior

import android.content.Intent
import com.lostheep.cleanarchitectureexample.presentation.ui.global.BaseMvpActivity
import ru.terrakok.cicerone.commands.Command
import ru.terrakok.cicerone.commands.Forward

/**
 * Nurtelecom
 * Created by lostsheep on 20.03.18:12:13.
 */
class ForwardBehaviourAsNewTask(
        private val key: String?,
        private val actTo: Class<*>) : CommandBehaviour {

    override fun exec(from: BaseMvpActivity, command: Command): Boolean {
        if (command is Forward) {
            val sKey = command.screenKey
            if (key != null && key != sKey) {
                return false
            }
            val intent = Intent(from, actTo)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            from.startActivity(intent)
            from.finish()
        }
        return true
    }
}