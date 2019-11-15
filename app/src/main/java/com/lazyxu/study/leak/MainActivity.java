package com.lazyxu.study.leak;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;

import com.lazyxu.study.R;
import com.lazyxu.study.entity.Student;
import com.lazyxu.study.recyclerview.RecyclerviewActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inflate);
        findViewById(R.id.tv_timer).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Student student=new Student(2019,"lazyxu",28);
                Intent intent=new Intent(MainActivity.this, RecyclerviewActivity.class);
                intent.putExtra("key",true);
                startActivity(intent);
            }
        });
    }
}
