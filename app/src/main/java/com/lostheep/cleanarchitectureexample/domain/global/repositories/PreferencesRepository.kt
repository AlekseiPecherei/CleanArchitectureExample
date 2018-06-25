package com.lostheep.cleanarchitectureexample.domain.global.repositories

import io.reactivex.Completable
import io.reactivex.Single

/**
 * CleanArchitectureExample
 * Created by lostsheep on 25.06.18:14:11.
 */
interface PreferencesRepository {

    fun isFirstStart(): Single<Boolean>

    fun logout(): Completable
}