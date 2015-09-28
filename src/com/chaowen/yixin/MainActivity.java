package com.chaowen.yixin;

import android.os.Bundle;

import com.jeremyfeinstein.slidingmenu.lib.app.SlidingActivity;

/**
 * Created by Administrator on 2015/9/28.
 */
public class MainActivity extends SlidingActivity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBehindContentView(R.layout.left_layout);
        setContentView(R.layout.fragment_left_layout);
    }

}
