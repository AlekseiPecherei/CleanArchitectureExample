package com.lostheep.cleanarchitectureexample.presentation.mvp.global.routing.behavior

import com.lostheep.cleanarchitectureexample.presentation.ui.global.BaseMvpActivity
import ru.terrakok.cicerone.commands.Back
import ru.terrakok.cicerone.commands.Command

/**
 * Nurtelecom
 * Created by lostsheep on 19.03.18:15:25.
 */
class BackBehaviour : CommandBehaviour {

    override fun exec(from: BaseMvpActivity, command: Command): Boolean {
        if (command is Back) {
            from.finish()
        }
        return true
    }
}