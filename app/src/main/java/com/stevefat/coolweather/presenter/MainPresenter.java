package com.stevefat.coolweather.presenter;

import android.support.annotation.NonNull;
import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.stevefat.coolweather.AppConstants;
import com.stevefat.coolweather.contract.MainContract;
import com.stevefat.coolweather.model.http.ApiClient;
import com.stevefat.coolweather.model.http.Service.WeatherService;
import com.stevefat.coolweather.model.http.entity.Weather;
import com.stevefat.coolweather.util.CheckCode;
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


    public MainPresenter(@NonNull MainContract.View mainView) {
        mMainView = mainView;
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

                mMainView.showLoadingStatisticsError(e);
            }

            @Override
            public void onNext(ResponseBody responseBody) {
                try {
                    Weather weather = new Weather();
                    String result = responseBody.string();
                    weather = JSON.parseObject(result, Weather.class);
                    String resultCode = CheckCode.valiteCode(Integer.valueOf(weather.getRetCode()));
                    if (resultCode.equals("1")) {
                        mMainView.displayWeather(weather);
                    } else {
                        //错误的情况下输出log日志
                        Logger.e(resultCode);
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
        //获取一下本地存储的数据
        cityName = "洛阳";
        //根据本地数据获取网络数据
        loadWeather(cityName);
    }

    @Override
    public void unsubscribe() {
        mSubscription.clear();
    }
}
