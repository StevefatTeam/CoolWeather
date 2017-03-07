package com.stevefat.coolweather.presenter;

import android.support.annotation.NonNull;
import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.stevefat.coolweather.AppConstants;
import com.stevefat.coolweather.contract.MainContract;
import com.stevefat.coolweather.model.http.ApiClient;
import com.stevefat.coolweather.model.http.Service.WeatherService;
import com.stevefat.coolweather.model.http.entity.Weather;
import com.stevefat.coolweather.util.Logger;

import java.io.IOException;

import okhttp3.ResponseBody;
import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by stevefat on 2017/3/4.
 */

public class MainPresenter implements MainContract.Presenter {
    private final MainContract.View mMainView;
    private String cityName;

    CompositeSubscription mSubscription;


    public MainPresenter(@NonNull MainContract.View mainView, String cityName) {
        mMainView = mainView;
        this.cityName = cityName;
        this.mSubscription = new CompositeSubscription();
        mMainView.setPresenter(this);
    }


    @Override
    @NonNull
    public void loadWeather(String cityName) {
        //这里开始加载数据
        Observable<ResponseBody> obs = ApiClient.getInstance().getApiManagerServices().getWeather(AppConstants.KEY, this.cityName);

        Subscription subscription = obs.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<ResponseBody>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                mMainView.showLoadingStatisticsError();
            }

            @Override
            public void onNext(ResponseBody responseBody) {
                try {
                    Weather weather = new Weather();
                    String result = responseBody.string();
                    weather = JSON.parseObject(result, Weather.class);
//                    Log.e("onNext", responseBody.string());
//                    Logger.e(responseBody.string());
                    if (weather.getRetCode().equals("200")) {
                        mMainView.displayWeather(weather);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        mSubscription.add(subscription);

    }

    @Override
    public void subscribe() {
        loadWeather(cityName);
    }

    @Override
    public void unsubscribe() {
        mSubscription.clear();
    }
}
