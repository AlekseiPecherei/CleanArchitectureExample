package com.lostheep.cleanarchitectureexample.presentation.mvp.global.routing.behavior

import com.lostheep.cleanarchitectureexample.presentation.ui.global.BaseMvpActivity
import ru.terrakok.cicerone.commands.Command

/**
 * Nurtelecom
 * Created by lostsheep on 19.03.18:15:23.
 */
interface CommandBehaviour {
    fun exec(from: BaseMvpActivity, command: Command): Boolean
}