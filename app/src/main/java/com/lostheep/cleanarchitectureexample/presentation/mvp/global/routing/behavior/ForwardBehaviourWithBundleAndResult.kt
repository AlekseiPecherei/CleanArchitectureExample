package com.lostheep.cleanarchitectureexample.presentation.mvp.global.routing.behavior

import android.content.Intent
import android.os.Bundle
import com.lostheep.cleanarchitectureexample.presentation.ui.global.BaseMvpActivity
import ru.terrakok.cicerone.commands.Command
import ru.terrakok.cicerone.commands.Forward

/**
 * Nurtelecom
 * Created by lostsheep on 25.04.18:16:47.
 */
class ForwardBehaviourWithBundleAndResult(
        private val key: String?,
        private val actTo: Class<*>) : CommandBehaviour {

    override fun exec(from: BaseMvpActivity, command: Command): Boolean {
        if (command is Forward) {
            val sKey = command.screenKey
            if (key != null && key != sKey) {
                return false
            }
            val args = command.transitionData as Bundle
            val requestCode = args.getInt("requestCode")
            val intent = Intent(from, actTo)
            intent.putExtras(args)
            from.startActivityForResult(intent, requestCode)
        }
        return true
    }
}