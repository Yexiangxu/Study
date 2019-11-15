package com.lazyxu.study.service

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import androidx.appcompat.app.AppCompatActivity
import com.lazyxu.study.IUserManager
import com.lazyxu.study.R
import kotlinx.android.synthetic.main.activity_service.*


/**
 * User:Lazy_xu
 * Data:2019/11/11
 * Description:
 * FIXME
 */
class ServiceActivity : AppCompatActivity() {
    private lateinit var intentStart: Intent
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service)
        btnBind.setOnClickListener { bindService() }
        btnAdd.setOnClickListener {
            var numb1 = etNumb1.text.toString().toInt()
            var numb2 = etNumb2.text.toString().toInt()
            var sum = iUserService?.add(numb1, numb2)
            tvResult.text = sum.toString()

        }
        btnStart.setOnClickListener {
            intentStart = Intent(this, StartService::class.java)
            startService(intentStart)
        }
        btnStopStartService.setOnClickListener { stopService(intentStart) }
    }

    private var iUserService: IUserManager? = null
    private val service = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            iUserService = IUserManager.Stub.asInterface(service)
        }

        override fun onServiceDisconnected(name: ComponentName?) {
            iUserService = null
        }
    }

    private fun bindService() {
//        val intent = Intent(this, IRemoteService::class.java)
//        bindService(intent, service, Context.BIND_AUTO_CREATE)
        startActivity(Intent(this,ServiceBAcitvity::class.java))
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}
