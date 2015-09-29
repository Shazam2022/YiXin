package com.chaowen.yixin;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ImageButton;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

/**
 * Created by Administrator on 2015/9/28.
 */
public class MainActivity extends SlidingFragmentActivity implements View.OnClickListener{
    ImageButton imageButton_menu;
    SlidingMenu slidingMenu;
    Fragment fragment_main, fragment_menu;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        imageButton_menu = (ImageButton)findViewById(R.id.imagebutton_menu);
        imageButton_menu.setOnClickListener(this);
        initSlidingMenu();
    }

    private void initSlidingMenu() {
        setBehindContentView(R.layout.left_layout);
        fragment_main = new Fragment_yixin();
        fragment_menu = new MenuFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.left_layout, fragment_menu).commit();
        getSupportFragmentManager().beginTransaction().replace(R.id.main_layout_fragment, fragment_main).commit();
        slidingMenu = getSlidingMenu();
        slidingMenu.setMode(SlidingMenu.LEFT);
        slidingMenu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
        slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
    }

    @Override
    public void onClick(View v) {

    }


}
