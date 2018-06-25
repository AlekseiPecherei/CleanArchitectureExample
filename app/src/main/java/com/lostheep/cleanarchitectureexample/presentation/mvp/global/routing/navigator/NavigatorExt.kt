package com.lostheep.cleanarchitectureexample.presentation.mvp.global.routing.navigator

import com.lostheep.cleanarchitectureexample.presentation.mvp.global.routing.behavior.*
import com.lostheep.cleanarchitectureexample.presentation.ui.global.BaseMvpActivity
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.commands.Command
import java.util.*

/**
 * Nurtelecom
 * Created by lostsheep on 19.03.18:15:37.
 */
open class NavigatorExt(private val activity: BaseMvpActivity) : Navigator {

    private val behaviours = ArrayList<CommandBehaviour>()

    fun addBack(): NavigatorExt {
        addBehaviour(BackBehaviour())
        return this
    }

    fun addForward(key: String?, c: Class<*>): NavigatorExt {
        addBehaviour(ForwardBehaviour(key, c))
        return this
    }

    fun addForwardAsNewTask(key: String?, c: Class<*>): NavigatorExt {
        addBehaviour(ForwardBehaviourAsNewTask(key, c))
        return this
    }

    fun addReplace(key: String?, action: Runnable): NavigatorExt {
        addBehaviour(ReplaceBehaviour(key, action))
        return this
    }

    private fun addBehaviour(behaviour: CommandBehaviour) {
        behaviours.add(behaviour)
    }

    override fun applyCommand(command: Command) {
        for (behaviour in behaviours) {
            behaviour.exec(activity, command)
        }
    }

    fun addForwardWithBundle(key: String?, c: Class<*>): NavigatorExt {
        addBehaviour(ForwardBehaviourWithBundle(key, c))
        return this
    }

    fun addForwardWithResult(key: String?, c: Class<*>): NavigatorExt {
        addBehaviour(ForwardBehaviourWithResult(key, c))
        return this
    }

    fun addForwardWithBundleAndResult(key: String?, c: Class<*>): NavigatorExt {
        addBehaviour(ForwardBehaviourWithBundleAndResult(key, c))
        return this
    }

    fun addForwardToWeb(key: String?): NavigatorExt {
        addBehaviour(ForwardToWeb(key))
        return this
    }
}