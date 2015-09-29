package com.chaowen.yixin;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Administrator on 2015/9/29.
 */
public class MenuFragment extends Fragment implements View.OnClickListener{
    View toolbox_yixin, toolbox_circle, toolbox_setting;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_left_layout, container, false);
        toolbox_yixin = view.findViewById(R.id.toolbox_yixin);
        toolbox_circle = view.findViewById(R.id.toolbox_circle);
        toolbox_setting = view.findViewById(R.id.toolbox_setting);
        toolbox_setting.setOnClickListener(this);
        toolbox_circle.setOnClickListener(this);
        toolbox_yixin.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        Fragment fragment = null;
        switch (v.getId()){
            case R.id.toolbox_yixin:
                fragment = new Fragment_yixin();
                toolbox_yixin.setSelected(true);
                toolbox_circle.setSelected(false);
                toolbox_setting.setSelected(false);
                break;
            case R.id.toolbox_circle:
                fragment = new Fragment_circle();
                toolbox_yixin.setSelected(false);
                toolbox_circle.setSelected(true);
                toolbox_setting.setSelected(false);
                break;
            case R.id.toolbox_setting:
                fragment = new Fragment_setting();
                toolbox_yixin.setSelected(false);
                toolbox_circle.setSelected(false);
                toolbox_setting.setSelected(true);
                break;
            default:
                break;
        }
        if(fragment!= null){
            switchFragment(fragment);
        }
    }

    private void switchFragment(Fragment fragment) {
        if(getActivity()!=null){
            MainActivity mainActivity = (MainActivity)getActivity();
            mainActivity.switchFragment(fragment);
        }
    }
}
