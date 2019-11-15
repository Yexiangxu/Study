package com.lazyxu.study.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.os.RemoteException

import com.lazyxu.study.IUserManager

/**
 * User:Lazy_xu
 * Data:2019/11/11
 * Description:
 * FIXME
 */
class IRemoteService : Service() {
    private val iBinder = object : IUserManager.Stub() {
        @Throws(RemoteException::class)
        override fun add(num1: Int, num2: Int): Int {
            return num1 + num2
        }
    }

    override fun onBind(intent: Intent): IBinder? {
        return iBinder
    }
}
