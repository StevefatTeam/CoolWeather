package com.stevefat.coolweather.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.stevefat.coolweather.R;
import com.stevefat.coolweather.presenter.MainPresenter;
import com.stevefat.coolweather.util.ActivityUtils;
import com.stevefat.coolweather.util.Logger;
import com.stevefat.coolweather.view.fragment.MainFragment;

public class MainActivity extends BaseActivity {


    @Override
    protected void initView() {

        MainFragment taskDetailFragment = (MainFragment) getSupportFragmentManager()
                .findFragmentById(R.id.contentFrame);

        if (taskDetailFragment == null) {
            taskDetailFragment = MainFragment.newInstance("北京");

            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),
                    taskDetailFragment, R.id.contentFrame);
        }
        new MainPresenter(taskDetailFragment,"北京");
//        Logger.getLogLevel()
    }

    @Override
    protected int getLayoutView() {
        return R.layout.activity_main;
    }

    @Override
    public void getData() {

    }
}
