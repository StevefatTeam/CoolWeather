package com.stevefat.coolweather;

import android.app.Application;

import com.stevefat.coolweather.model.db.entity.City;
import com.stevefat.coolweather.model.db.entity.ProvinceCity;
import com.stevefat.coolweather.util.CityUtil;
import com.stevefat.coolweather.util.LogLevel;
import com.stevefat.coolweather.util.Logger;

import org.litepal.LitePal;
import org.litepal.crud.DataSupport;

import java.io.IOException;

/**
 * Created by stevefat on 2017/3/2.
 */

public class WeatherApp extends Application {
    private static WeatherApp instance;

    public static WeatherApp getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        LitePal.initialize(this);
        new Logger().init("coolWeather");
        try {
            //存入城市的数据
//            int count = DataSupport.findAll(City.class).size();
            int count = DataSupport.findAll(ProvinceCity.class).size();
            if (count <=0) {
                CityUtil.parsingJsonCity(this);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
