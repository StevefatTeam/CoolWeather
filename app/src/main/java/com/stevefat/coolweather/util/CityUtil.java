package com.stevefat.coolweather.util;

import android.content.Context;
import android.content.res.AssetManager;
import android.support.annotation.NonNull;

import com.alibaba.fastjson.JSON;
import com.stevefat.coolweather.model.db.entity.ProvinceCity;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.List;

import okio.BufferedSource;
import okio.Okio;
import okio.Source;

/**
 * Created by stevefat on 2017/3/2.
 */

public class CityUtil {

    //解释城市json 文件
    public static void parsingJsonCity(@NonNull Context context) throws IOException {

        AssetManager assetManager = context.getAssets();
//        InputStream inputStream = assetManager.open("city.json");
        InputStream inputStream = assetManager.open("ProvinceCity.json");
        //读文件
        Source source = Okio.source(inputStream);
        //通过source拿到 bufferedSource
        BufferedSource bSource = Okio.buffer(source);
        String fileContent = bSource.readString(Charset.forName("utf-8"));
        List<ProvinceCity> cityAlls = JSON.parseArray(fileContent, ProvinceCity.class);
        ProvinceCity.saveAll(cityAlls);
//        List<City> cityAlls = JSON.parseArray(fileContent, City.class);
//        City.saveAll(cityAlls);

    }

}
