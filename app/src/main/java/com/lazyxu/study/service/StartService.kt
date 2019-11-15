package com.lazyxu.study.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

/**
 * User:Lazy_xu
 * Data:2019/11/12
 * Description:
 * FIXME
 */
class StartService : Service() {

    override fun onBind(intent: Intent): IBinder? {
        return null
    }
    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "onCreate")

    }

    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        Log.d(TAG, "onStartCommand")
        stopSelf()
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")

    }

    override fun onRebind(intent: Intent?) {
        super.onRebind(intent)
    }

    companion object {
        private val TAG = "StartService"
    }
}
