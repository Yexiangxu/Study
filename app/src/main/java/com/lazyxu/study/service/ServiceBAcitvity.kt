package com.lazyxu.study.service

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

import com.lazyxu.study.R

/**
 * User:Lazy_xu
 * Data:2019/11/12
 * Description:
 * FIXME
 */
class ServiceBAcitvity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val intentStart = Intent(this, StartService::class.java)
        startService(intentStart)
    }
}
