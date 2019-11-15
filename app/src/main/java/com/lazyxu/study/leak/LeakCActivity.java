package com.lazyxu.study.leak;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.lazyxu.study.R;

/**
 * User: xuyexiang
 * Date: 2019/06/24
 * Description:
 * FIXME
 */
public class LeakCActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
    }
}
