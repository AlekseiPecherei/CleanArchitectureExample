package com.lostheep.cleanarchitectureexample.data.repositories

import android.content.Context
import android.content.SharedPreferences
import com.lostheep.cleanarchitectureexample.domain.global.repositories.PreferencesRepository
import io.reactivex.Completable
import io.reactivex.Single

/**
 * CleanArchitectureExample
 * Created by lostsheep on 25.06.18:14:10.
 */
class PreferencesRepositoryImpl(context: Context) : PreferencesRepository {
    private val APP_PREFS_FILE_NAME = "APP_PREFS_FILE_NAME"
    private val IS_FIRST_START = "IS_FIRST_START"

    private val preferences: SharedPreferences = context.getSharedPreferences(APP_PREFS_FILE_NAME, Context.MODE_PRIVATE)

    override fun isFirstStart(): Single<Boolean> {
        return Single.fromCallable {
            val temp = preferences.getBoolean(IS_FIRST_START, true)
            preferences.edit().putBoolean(IS_FIRST_START, false).apply()
            return@fromCallable temp
        }
    }

    override fun logout(): Completable {
        return Completable.fromRunnable({
            preferences.edit()
                    .apply()
        })
    }
}