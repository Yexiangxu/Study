package com.lazyxu.study.thread;

import androidx.databinding.DataBindingUtil;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;

import com.lazyxu.study.R;
import com.lazyxu.study.databinding.ActivityThreadBinding;

/**
 * User:Lazy_xu
 * Data:2019/11/13
 * Description:
 * FIXME
 */
public class ThreadTestActivity extends AppCompatActivity {
    ActivityThreadBinding mBinding;
    private static final String TAG = "ThreadActivity";
    private boolean isBegin=true;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding= DataBindingUtil.setContentView(this, R.layout.activity_thread);
        Thread thread = new Thread() {
            @Override
            public void run() {
                Log.d(TAG, "thread1开始了");

            }
        };
        mBinding.btnStart.setOnClickListener(v -> thread.start());
    }
}
