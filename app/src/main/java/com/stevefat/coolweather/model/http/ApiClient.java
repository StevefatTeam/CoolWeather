package com.stevefat.coolweather.model.http;


import com.stevefat.coolweather.model.http.Service.WeatherService;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;

/**
 * Created by stevefat on 2017/3/2.
 */

public class ApiClient {


    //服务提供者
    private static ApiClient instance;
    //网络接口服务提供
    private WeatherService mWeatherService;

    public static ApiClient getInstance() {
        if (instance == null) {
            instance = new ApiClient();
        }
        return instance;
    }


    public ApiClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiConstants.BASE_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();


        this.mWeatherService = retrofit.create(WeatherService.class);
    }

    /**
     * 获取提供服务的接口
     *
     * @return
     */
    public WeatherService getApiManagerServices() {
        return mWeatherService;
    }

}
