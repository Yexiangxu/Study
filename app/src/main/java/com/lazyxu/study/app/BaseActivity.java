package com.lazyxu.study.app;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.lazyxu.study.R;

public class BaseActivity extends AppCompatActivity {

    // 广告显示时间
    private long mADDuration = 1000 * 4;
    // 广告显示间隔时间, 间隔内不出现广告
    private long mADInterval = 1000 * 20;
    // 上次显示广告的时间
    private long mLastADTime = 0;
    //广告页的view
    private View mAdView;
    private TextView mTvTimer;
    private CountDownTimer mTimer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initAdView();
    }

    private void initAdView() {
        mAdView = View.inflate(this, R.layout.activity_inflate, null);
        mTvTimer = (TextView) mAdView.findViewById(R.id.tv_timer);
        mTimer = new CountDownTimer(mADDuration, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                String text = (millisUntilFinished / 1000) + "s";
                mTvTimer.setText(text);
            }

            @Override
            public void onFinish() {
                if (mAdView != null) {
                    mTvTimer.setText("0s");
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            getWindowManager().removeViewImmediate(mAdView);
                        }
                    }, 100);
                }
            }
        };
    }

    @Override
    protected void onStart() {
        super.onStart();
        // 判断是否从后台恢复, 且时间间隔符合要求, 显示广告页面
        boolean isFromBackToFront = LifecycleHandler.sAppState == LifecycleHandler.STATE_BACK_TO_FRONT;
        if (isFromBackToFront && canShowAD()) {
            showAD();
        }
    }

    /**
     * 显示广告
     */
    private void showAD() {
        // 显示广告页面
        createADView();
        // 随机显示一个广告页
        // 开始倒计时
        mTimer.cancel();
        mTimer.start();
        // 记录显示广告的时间, 以便后续比对
        mLastADTime = System.currentTimeMillis();
    }

    /**
     * 判断两次时间是否大于规定的间隔
     *
     * @return true大于间隔, 否则false
     */
    private boolean canShowAD() {
        return System.currentTimeMillis() - mLastADTime > mADInterval;
    }

    private void createADView() {
        WindowManager.LayoutParams params = new WindowManager.LayoutParams();
        params.x = 0;
        params.y = 0;
        params.width = WindowManager.LayoutParams.MATCH_PARENT;
        params.height = WindowManager.LayoutParams.MATCH_PARENT;
        getWindowManager().addView(mAdView, params);
    }



}
