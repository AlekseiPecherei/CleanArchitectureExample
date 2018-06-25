package com.lostheep.cleanarchitectureexample.presentation.mvp.global

import android.annotation.SuppressLint
import android.content.Context
import com.lostheep.cleanarchitectureexample.domain.global.HardwareInfoManager
import java.io.File
import java.text.SimpleDateFormat

/**
 * Nurtelecom
 * Created by lostsheep on 29.03.18:12:39.
 */
class AndroidHardwareInfoManager(private val context: Context) : HardwareInfoManager {

    @SuppressLint("SimpleDateFormat")
    override fun getAppBuildDateVersion(): String {
        var timeStamp = ""
        try {
            val appInfo = context.packageManager.getApplicationInfo(context.packageName, 0)
            val appFile = appInfo.sourceDir
            val time = File(appFile).lastModified()
            val formatter = SimpleDateFormat("dd.MM.yyyy")
            timeStamp = formatter.format(time)
        } catch (e: Exception) {
        }
        return timeStamp
    }
}