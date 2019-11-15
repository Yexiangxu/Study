package com.lazyxu.study.thread

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.lazyxu.study.R
import kotlinx.android.synthetic.main.activity_service.*

/**
 * User:Lazy_xu
 * Data:2019/11/13
 * Description:
 * FIXME
 */
class ThreadActivity : AppCompatActivity() {
    private val isBegin: Boolean = true
    private val TAG = "ThreadActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thread)
        val thread = Thread {
            kotlin.run {
                Log.d(TAG, "thread1开始了")
                Thread.sleep(1000)
            }
        }
        btnStart.setOnClickListener {
            thread.run()
            Log.d(TAG, "btnStart开始了")
        }
    }

}
