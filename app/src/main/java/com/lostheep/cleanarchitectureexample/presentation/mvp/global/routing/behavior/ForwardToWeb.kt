package com.lostheep.cleanarchitectureexample.presentation.mvp.global.routing.behavior

import android.content.Intent
import android.net.Uri
import com.lostheep.cleanarchitectureexample.presentation.ui.global.BaseMvpActivity
import ru.terrakok.cicerone.commands.Command
import ru.terrakok.cicerone.commands.Forward

/**
 * kievstar_streamig
 * Created by lostsheep on 24.05.18:14:33.
 */
class ForwardToWeb(private val key: String?) : CommandBehaviour {

    override fun exec(from: BaseMvpActivity, command: Command): Boolean {
        if (command is Forward) {
            val sKey = command.screenKey
            if (key != null && key != sKey) {
                return false
            }
            val url = command.transitionData as String
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            from.startActivity(intent)
        }
        return true
    }
}