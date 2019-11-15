package com.lazyxu.study.leak;

import android.widget.TextView;

/**
 * User: xuyexiang
 * Date: 2019/06/20
 * Description:
 * FIXME
 */
public class LeakTest {
    public static LeakTest instance;
    private static TextView mTextView;

    public static LeakTest getInstance() {
        if (instance == null) {
            instance = new LeakTest();
        }
        return instance;
    }

    public void setmTextView(TextView textView) {
        mTextView = textView;
    }
}
