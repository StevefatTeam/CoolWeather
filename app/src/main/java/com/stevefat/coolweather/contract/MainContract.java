package com.stevefat.coolweather.contract;

import com.stevefat.coolweather.activity.component.BasePresenter;
import com.stevefat.coolweather.activity.component.BaseView;
import com.stevefat.coolweather.model.http.entity.Weather;

/**
 * Created by stevefat on 2017/3/4.
 */

public interface MainContract {
    interface View extends BaseView<Presenter> {
        //显示数据
        void displayWeather(Weather weather);

        void showLoadingStatisticsError(Throwable e);
    }

    interface Presenter extends BasePresenter {
        //加载对应的数据
        void loadWeather(String cityName);
    }
}
