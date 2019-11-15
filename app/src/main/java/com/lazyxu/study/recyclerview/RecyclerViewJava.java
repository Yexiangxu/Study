package com.lazyxu.study.recyclerview;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.lazyxu.study.R;
import com.lazyxu.study.databinding.ActivityRecyclerviewBinding;

import java.util.ArrayList;

/**
 * User:Lazy_xu
 * Data:2019/10/31
 * Description:
 * FIXME lateinit :延迟初始化
 */
public class RecyclerViewJava extends AppCompatActivity {
    ActivityRecyclerviewBinding mDatabinding;
    private RvMainAdapter rvMainAdapter = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDatabinding = DataBindingUtil.setContentView(this, R.layout.activity_recyclerview);
        ArrayList<String> list = new ArrayList();
        for (int i = 0; i < 20; i++) {
            list.add("测试" + i);
        }

        mDatabinding.rvMain.setLayoutManager(new LinearLayoutManager(this));
        mDatabinding.rvMain.addItemDecoration(new DividerItemDecoration(this, 1));
        rvMainAdapter = new RvMainAdapter(this, list);
        mDatabinding.rvMain.setAdapter(rvMainAdapter);
        mDatabinding.tvChangeData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        LayoutInflater.from(this).inflate(R.layout.activity_recyclerview, null);

    }
}
