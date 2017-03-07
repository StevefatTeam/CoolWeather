package com.stevefat.coolweather.presenter;

import android.os.Bundle;

import com.stevefat.coolweather.contract.CityManagerContract;

/**
 * Created by stevefat on 2017/3/4.
 */

public class CityManagerPresenter implements CityManagerContract.Presenter {

    private CityManagerContract.View view;


    @Override
    public void loadCity() {

    }

    @Override
    public void subscribe() {
        //开始获取一些数据或者初始化一些需要用的数据
    }

    @Override
    public void unsubscribe() {

    }
}
