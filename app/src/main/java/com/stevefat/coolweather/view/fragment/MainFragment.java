package com.stevefat.coolweather.view.fragment;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.stevefat.coolweather.R;
import com.stevefat.coolweather.activity.BaseFragment;
import com.stevefat.coolweather.contract.MainContract;
import com.stevefat.coolweather.model.http.entity.Weather;
import com.stevefat.coolweather.util.DateUtil;
import com.stevefat.coolweather.util.Logger;
import com.stevefat.coolweather.view.adapter.MainRecycleAdapter;

import butterknife.BindView;

/**
 * Created by stevefat on 2017/3/4.
 */

public class MainFragment extends BaseFragment implements MainContract.View {

    @BindView(R.id.weather_update_time)
    TextView weatherUpdateTime;
    @BindView(R.id.weather_city)
    TextView weatherCity;
    @BindView(R.id.weather_air)
    TextView weatherAir;
    @BindView(R.id.weather_temp)
    TextView weatherTemp;
    @BindView(R.id.recycle_today)
    RecyclerView recycleToday;
    @BindView(R.id.recycle_lastDay)
    RecyclerView recycleLastDay;
//    @BindView(R.id.swipeRef)
//    SwipeRefreshLayout swipeRef;
    @BindView(R.id.week)
    TextView week;
    @BindView(R.id.week_day)
    TextView weekDay;
    @BindView(R.id.weather_img)
    ImageView weatherImg;
    @BindView(R.id.max_temp)
    TextView maxTemp;
    @BindView(R.id.min_temp)
    TextView minTemp;


    MainRecycleAdapter adapter;
    @BindView(R.id.day_weather_about)
    TextView dayWeatherAbout;
    @BindView(R.id.sunrise)
    TextView sunrise;
    @BindView(R.id.sunset)
    TextView sunset;
    @BindView(R.id.humidity)
    TextView humidity;
    @BindView(R.id.wind)
    TextView wind;
    @BindView(R.id.pollutionIndex)
    TextView pollutionIndex;
    @BindView(R.id.airCondition)
    TextView airCondition;
    @BindView(R.id.coldIndex)
    TextView coldIndex;
    @BindView(R.id.dressingIndex)
    TextView dressingIndex;
    @BindView(R.id.exerciseIndex)
    TextView exerciseIndex;
    @BindView(R.id.washIndex)
    TextView washIndex;

    private MainContract.Presenter mPresenter;
    private DateUtil dateUtil;

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
    public View getlayoutView(LayoutInflater inflater) {

        return inflater.inflate(R.layout.main_fragment_item, null);
    }

    @Override
    public void initView() {
        dateUtil = new DateUtil();

    }

    @Override
    public void setPresenter(MainContract.Presenter presenter) {
        this.mPresenter = presenter;

    }

    @Override
    public void displayWeather(Weather weather) {
        //最外层
        Weather.ResultBean resultBean = weather.getResult().get(0);
        //内层的第一个数据
        Weather.ResultBean.FutureBean futureBean = resultBean.getFuture().get(0);

        String updateTime = dateUtil.parseDate(resultBean.getUpdateTime(), getActivity());
        //更新时间
        weatherUpdateTime.setText(updateTime);
        //城市
        weatherCity.setText(resultBean.getCity());
        //空气质量 str
        weatherAir.setText(resultBean.getAirCondition());
        //今天的温度
        weatherTemp.setText(resultBean.getTemperature());

        //内层的今天天气
        week.setText(resultBean.getWeek());
        weekDay.setVisibility(View.VISIBLE);
        weekDay.setText(futureBean.getWeek());

        //内层的第一个今天的 最高和最低温度
        String temp = futureBean.getTemperature();
        String maxTempStr = temp.substring(0, temp.indexOf("C")).trim();
        String minTempStr = temp.substring(temp.indexOf("/") + 1, temp.lastIndexOf("C")).trim();
        maxTemp.setText(maxTempStr);
        minTemp.setText(minTempStr);

        //今天的24小时预报
        recycleToday.setVisibility(View.GONE);
        //后面几天的数据预报
        buildLastDay(resultBean);
        setBottomData(resultBean);

    }

    /**
     * 设置最低部的数据
     *
     * @param resultBean
     */
    private void setBottomData(Weather.ResultBean resultBean) {
        dayWeatherAbout.setText("");
        sunrise.setText(resultBean.getSunrise());
        sunset.setText(resultBean.getSunset());
        humidity.setText(resultBean.getHumidity().substring(resultBean.getHumidity().indexOf("：")+1));
        wind.setText(resultBean.getWind());
        pollutionIndex.setText(resultBean.getPollutionIndex());
        airCondition.setText(resultBean.getAirCondition());

        coldIndex.setText(resultBean.getColdIndex());
        dressingIndex.setText(resultBean.getDressingIndex());
        exerciseIndex.setText(resultBean.getExerciseIndex());
        washIndex.setText(resultBean.getWashIndex());

    }


    /**
     * 后面今天的数据集合
     *
     * @param resultBean
     */
    private void buildLastDay(Weather.ResultBean resultBean) {
        //设置布局管理器
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recycleLastDay.setLayoutManager(layoutManager);
        //数据构造并且显示
        adapter = new MainRecycleAdapter(resultBean.getFuture());
        recycleLastDay.setAdapter(adapter);
    }

    @Override
    public void showLoadingStatisticsError(Throwable e) {
//        Snackbar.make(localCity, "数据加载失败!", Snackbar.LENGTH_SHORT).show();
        Logger.e(e.getMessage());
    }
}
