package com.stevefat.coolweather.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.stevefat.coolweather.R;
import com.stevefat.coolweather.activity.BaseFragment;
import com.stevefat.coolweather.contract.MainContract;
import com.stevefat.coolweather.model.http.entity.Weather;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by stevefat on 2017/3/4.
 */

public class MainFragment extends BaseFragment implements MainContract.View {

    @BindView(R.id.local)
    TextView local;
    @BindView(R.id.local_city)
    TextView localCity;
    @BindView(R.id.send_weather)
    TextView sendWeather;
    @BindView(R.id.temp_num)
    TextView tempNum;
    @BindView(R.id.temp_du)
    TextView tempDu;
    @BindView(R.id.weather_name)
    TextView weatherName;
    @BindView(R.id.wind)
    TextView wind;
    private MainContract.Presenter mPresenter;

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
        return inflater.inflate(R.layout.main_fragment_item, null);
    }

    @Override
    public void initView() {

//        tv = (TextView) mView.findViewById(R.id.tv);
    }

    @Override
    public void setPresenter(MainContract.Presenter presenter) {
        this.mPresenter = presenter;

    }

    @Override
    public void displayWeather(Weather weather) {
        Weather.ResultBean  resultBean = weather.getResult().get(0);
        localCity.setText(resultBean.getCity());
        tempNum.setText(resultBean.getTemperature());
        weatherName.setText(resultBean.getWeather());
        wind.setText(resultBean.getWind());

    }

    @Override
    public void showLoadingStatisticsError() {
//        Snackbar.make(tv, "", Snackbar.LENGTH_SHORT).show();
        Log.e("showError", "数据加载失败....");
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }
}
