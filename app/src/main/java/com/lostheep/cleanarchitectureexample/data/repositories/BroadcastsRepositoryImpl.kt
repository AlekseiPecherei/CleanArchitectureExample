package com.lostheep.cleanarchitectureexample.data.repositories

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Looper
import com.lostheep.cleanarchitectureexample.domain.global.repositories.BroadcastsRepository
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers.mainThread

/**
 * CleanArchitectureExample
 * Created by lostsheep on 25.06.18:14:26.
 */
class BroadcastsRepositoryImpl constructor(private val context: Context) : BroadcastsRepository {

    override fun events(): Observable<Intent> {
        return Observable.create { emitter ->
            val receiver = object : BroadcastReceiver() {
                override fun onReceive(context: Context, intent: Intent) {
                    emitter.onNext(intent)
                }
            }
            val intentFilter = IntentFilter("filter")
            context.registerReceiver(receiver, intentFilter)

            emitter.setCancellable {
                if (Looper.getMainLooper() == Looper.myLooper()) {
                    context.unregisterReceiver(receiver)
                } else {
                    val inner = mainThread().createWorker()
                    inner.schedule({
                        context.unregisterReceiver(receiver)
                        inner.dispose()
                    })
                }
            }
        }
    }

}