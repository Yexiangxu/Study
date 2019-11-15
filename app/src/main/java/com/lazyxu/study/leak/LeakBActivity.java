package com.lazyxu.study.leak;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;

import com.lazyxu.study.R;

public class LeakBActivity extends AppCompatActivity {
    private Button showButton;
//    private static Context context;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c);
        showButton = findViewById(R.id.tv_c);
        showButton.setOnClickListener(v -> {
            //回传值
            Intent intent = new Intent(LeakBActivity.this, LeakCActivity.class);
            startActivity(intent);
        });
        LeakTest.getInstance().setmTextView(showButton);
//        context = this;
//        initData();

        Intent intent = getIntent();
        String action = intent.getAction();
        if (Intent.ACTION_VIEW.equals(action)) {
            Uri uri = intent.getData();
            if (uri != null) {
                String name = uri.getQueryParameter("name");
                String age = uri.getQueryParameter("age");
            }
        }


//    private void initData() {
//        // 每隔1s执行一次事件
//        Observable.interval(1, TimeUnit.SECONDS)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Observer<Long>() {
//                    @Override
//                    public void onSubscribe(@NonNull Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onNext(@NonNull Long aLong) {
//                        Log.i("接收数据", String.valueOf(aLong));
//                    }
//
//                    @Override
//                    public void onError(@NonNull Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });
//    }
    }
}