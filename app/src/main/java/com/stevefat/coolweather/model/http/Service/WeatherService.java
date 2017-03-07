package com.stevefat.coolweather.model.http.Service;

import com.stevefat.coolweather.model.http.ApiClient;
import com.stevefat.coolweather.model.http.ApiConstants;
import com.stevefat.coolweather.model.http.entity.Weather;

import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by stevefat on 2017/3/2.
 */

public interface WeatherService {

    /**
     *  * http://apicloud.mob.com/v1/weather/query?key=520520test&city=洛阳
     * 获取天气数据
     * @param key  apikey
     * @param city 城市名字
     * @return
     */
    @GET("query")
    Observable<ResponseBody> getWeather(@Query("key") String key, @Query("city") String city);


}
