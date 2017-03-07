package com.stevefat.coolweather.model.db.entity;

import org.litepal.crud.DataSupport;

/**
 * Created by stevefat on 2017/3/2.
 * 获取城市的集合 http://files.heweather.com/china-city-list.json
 */

public class City extends DataSupport {

    /**
     * ID : 1
     * cityName : 北京
     * cityEN : Beijing
     * townID : CHBJ000000
     * townName : 北京
     * townEN : Beijing
     */
    private long id;
    private String cityName;  // 所属城市
    private String cityEN;     //所属城市拼音
    private String townID;
    private String townName; //市、县、区 等
    private String townEN;   //市县区 拼音

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCityEN() {
        return cityEN;
    }

    public void setCityEN(String cityEN) {
        this.cityEN = cityEN;
    }

    public String getTownID() {
        return townID;
    }

    public void setTownID(String townID) {
        this.townID = townID;
    }

    public String getTownName() {
        return townName;
    }

    public void setTownName(String townName) {
        this.townName = townName;
    }

    public String getTownEN() {
        return townEN;
    }

    public void setTownEN(String townEN) {
        this.townEN = townEN;
    }
}
