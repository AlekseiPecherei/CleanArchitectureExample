package com.lostheep.cleanarchitectureexample.domain.global

import com.lostheep.cleanarchitectureexample.ExampleApplication
import com.lostheep.cleanarchitectureexample.data.repositories.ContentRepositoryImpl
import com.lostheep.cleanarchitectureexample.data.repositories.PreferencesRepositoryImpl

/**
 * Nurtelecom
 * Created by lostsheep on 06.04.18:14:40.
 */
open class BaseInteractor {
    val repository = ContentRepositoryImpl()
    val preferences = PreferencesRepositoryImpl(ExampleApplication.context)
}