package com.stevefat.coolweather.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.stevefat.coolweather.R;
import com.stevefat.coolweather.activity.BaseFragment;
import com.stevefat.coolweather.contract.MainContract;
import com.stevefat.coolweather.model.http.entity.Weather;
import com.stevefat.coolweather.util.Logger;

/**
 * Created by stevefat on 2017/3/4.
 */

public class MainFragment extends BaseFragment implements MainContract.View {

    private MainContract.Presenter mPresenter;

    private TextView tv;

    public static MainFragment newInstance(String cityName) {

        Bundle args = new Bundle();
        args.putString("cityName", cityName);
        MainFragment fragment = new MainFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.subscribe();
    }

    @Override
    public void onPause() {
        super.onPause();
        mPresenter.unsubscribe();
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View getlayoutView(LayoutInflater inflater) {
        ;
        return inflater.inflate(R.layout.main_fragment_item, null);
    }

    @Override
    public void initView() {
        tv = (TextView) mView.findViewById(R.id.tv);
    }

    @Override
    public void setPresenter(MainContract.Presenter presenter) {
        this.mPresenter = presenter;
//        presenter.loadWeather("北京");

    }

    @Override
    public void displayWeather(Weather weather) {
        tv.setText(weather.getMsg());
    }

    @Override
    public void showLoadingStatisticsError() {
        Snackbar.make(tv, "", Snackbar.LENGTH_SHORT).show();
        Log.e("showError", "数据加载失败....");
    }


}
