package com.lostheep.cleanarchitectureexample.domain.global.repositories

import android.content.Intent
import io.reactivex.Observable

/**
 * CleanArchitectureExample
 * Created by lostsheep on 25.06.18:14:27.
 */
interface BroadcastsRepository {
    fun events(): Observable<Intent>
}