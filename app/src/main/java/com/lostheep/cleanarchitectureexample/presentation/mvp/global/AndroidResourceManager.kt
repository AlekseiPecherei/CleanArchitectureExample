package com.lostheep.cleanarchitectureexample.presentation.mvp.global

import android.content.Context
import com.lostheep.cleanarchitectureexample.domain.global.ResourcesManager

/**
 * Nurtelecom
 * Created by lostsheep on 29.03.18:12:21.
 */
class AndroidResourceManager(private val context: Context) : ResourcesManager {

    override fun getString(resourceId: Int): String {
        return context.getString(resourceId)
    }
}