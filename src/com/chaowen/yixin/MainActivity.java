package com.chaowen.yixin;

import android.app.Fragment;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingActivity;

/**
 * Created by Administrator on 2015/9/28.
 */
public class MainActivity extends SlidingActivity implements View.OnClickListener{
    ImageButton imageButton_menu;
    SlidingMenu slidingMenu;
    Fragment fragment_main;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        imageButton_menu = (ImageButton)findViewById(R.id.imagebutton_menu);
        imageButton_menu.setOnClickListener(this);
        initSlidingMenu();
    }

    private void initSlidingMenu() {
        setBehindContentView(R.layout.left_layout);

        slidingMenu = getSlidingMenu();
        slidingMenu.setMode(SlidingMenu.LEFT);
        slidingMenu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
        slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
    }

    @Override
    public void onClick(View v) {

    }


}
