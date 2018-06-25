package com.lostheep.cleanarchitectureexample.domain.global

import android.support.annotation.StringRes

/**
 * Nurtelecom
 * Created by lostsheep on 29.03.18:12:21.
 */
interface ResourcesManager {

    fun getString(@StringRes resourceId: Int): String
}