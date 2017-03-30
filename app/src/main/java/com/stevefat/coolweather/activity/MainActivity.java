package com.stevefat.coolweather.activity;


import android.graphics.Color;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;

import com.stevefat.coolweather.R;
import com.stevefat.coolweather.presenter.MainPresenter;
import com.stevefat.coolweather.util.ActivityUtils;
import com.stevefat.coolweather.util.ShareUtil;
import com.stevefat.coolweather.view.fragment.MainFragment;

/**
 * 主界面
 */

public class MainActivity extends BaseActivity {


    @Override
    protected void initView() {
        //这里需要获取一下sp 中保存的名字
        String cityName = (String) ShareUtil.get(this, "cityName", "北京");
        //如果有就直接使用,否则就跳转定位界面,定位
        if (TextUtils.isEmpty(cityName)) {
            //跳转到定位界面

        } else {
            MainFragment taskDetailFragment = (MainFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.contentFrame);

            if (taskDetailFragment == null) {
                taskDetailFragment = MainFragment.newInstance(cityName);

                ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),
                        taskDetailFragment, R.id.contentFrame);
            }
            new MainPresenter(taskDetailFragment);

        }

    }

    @Override
    protected int getLayoutView() {
        if(Build.VERSION.SDK_INT>=21){
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN|View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }

        return R.layout.activity_main;
    }

    @Override
    public void getData() {

    }
}
