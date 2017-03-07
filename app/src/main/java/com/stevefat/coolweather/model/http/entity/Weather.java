package com.stevefat.coolweather.model.http.entity;

import java.util.List;

/**
 * Created by stevefat on 2017/3/2.
 */

public class Weather {

    /**
     * msg : success
     * result : [{"airCondition":"良","city":"北京","coldIndex":"易发期","date":"2017-03-06","distrct":"北京","dressingIndex":"薄冬衣","exerciseIndex":"不适宜","future":[{"date":"2017-03-06","dayTime":"多云","night":"晴","temperature":"10°C / -3°C","week":"今天","wind":"北风 4～5级"},{"date":"2017-03-07","dayTime":"晴","night":"晴","temperature":"8°C / -1°C","week":"星期二","wind":"北风 3～4级"},{"date":"2017-03-08","dayTime":"晴","night":"晴","temperature":"12°C / 0°C","week":"星期三","wind":"北风 3～4级"},{"date":"2017-03-09","dayTime":"晴","night":"晴","temperature":"15°C / 2°C","week":"星期四","wind":"南风 小于3级"},{"date":"2017-03-10","dayTime":"多云","night":"阴","temperature":"16°C / 4°C","week":"星期五","wind":"南风 小于3级"},{"date":"2017-03-11","dayTime":"阴","night":"晴","temperature":"17°C / 5°C","week":"星期六","wind":"北风 3～4级"},{"date":"2017-03-12","dayTime":"晴","night":"晴","temperature":"14°C / 2°C","week":"星期日","wind":"南风 小于3级"},{"date":"2017-03-13","dayTime":"局部多云","night":"局部多云","temperature":"15°C / 3°C","week":"星期一","wind":"西北风 3级"},{"date":"2017-03-14","dayTime":"少云","night":"局部多云","temperature":"14°C / 3°C","week":"星期二","wind":"东北偏东风 3级"},{"date":"2017-03-15","dayTime":"局部多云","night":"局部多云","temperature":"13°C / 2°C","week":"星期三","wind":"东南偏南风 3级"}],"humidity":"湿度：24%","pollutionIndex":"62","province":"北京","sunrise":"06:40","sunset":"18:11","temperature":"8℃","time":"15:30","updateTime":"20170306154507","washIndex":"非常适宜","weather":"多云","week":"周一","wind":"东北风4级"}]
     * retCode : 200
     */

    private String msg;
    private String retCode;
    private List<ResultBean> result;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getRetCode() {
        return retCode;
    }

    public void setRetCode(String retCode) {
        this.retCode = retCode;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * airCondition : 良
         * city : 北京
         * coldIndex : 易发期
         * date : 2017-03-06
         * distrct : 北京
         * dressingIndex : 薄冬衣
         * exerciseIndex : 不适宜
         * future : [{"date":"2017-03-06","dayTime":"多云","night":"晴","temperature":"10°C / -3°C","week":"今天","wind":"北风 4～5级"},{"date":"2017-03-07","dayTime":"晴","night":"晴","temperature":"8°C / -1°C","week":"星期二","wind":"北风 3～4级"},{"date":"2017-03-08","dayTime":"晴","night":"晴","temperature":"12°C / 0°C","week":"星期三","wind":"北风 3～4级"},{"date":"2017-03-09","dayTime":"晴","night":"晴","temperature":"15°C / 2°C","week":"星期四","wind":"南风 小于3级"},{"date":"2017-03-10","dayTime":"多云","night":"阴","temperature":"16°C / 4°C","week":"星期五","wind":"南风 小于3级"},{"date":"2017-03-11","dayTime":"阴","night":"晴","temperature":"17°C / 5°C","week":"星期六","wind":"北风 3～4级"},{"date":"2017-03-12","dayTime":"晴","night":"晴","temperature":"14°C / 2°C","week":"星期日","wind":"南风 小于3级"},{"date":"2017-03-13","dayTime":"局部多云","night":"局部多云","temperature":"15°C / 3°C","week":"星期一","wind":"西北风 3级"},{"date":"2017-03-14","dayTime":"少云","night":"局部多云","temperature":"14°C / 3°C","week":"星期二","wind":"东北偏东风 3级"},{"date":"2017-03-15","dayTime":"局部多云","night":"局部多云","temperature":"13°C / 2°C","week":"星期三","wind":"东南偏南风 3级"}]
         * humidity : 湿度：24%
         * pollutionIndex : 62
         * province : 北京
         * sunrise : 06:40
         * sunset : 18:11
         * temperature : 8℃
         * time : 15:30
         * updateTime : 20170306154507
         * washIndex : 非常适宜
         * weather : 多云
         * week : 周一
         * wind : 东北风4级
         */

        private String airCondition;
        private String city;
        private String coldIndex;
        private String date;
        private String distrct;
        private String dressingIndex;
        private String exerciseIndex;
        private String humidity;
        private String pollutionIndex;
        private String province;
        private String sunrise;
        private String sunset;
        private String temperature;
        private String time;
        private String updateTime;
        private String washIndex;
        private String weather;
        private String week;
        private String wind;
        private List<FutureBean> future;

        public String getAirCondition() {
            return airCondition;
        }

        public void setAirCondition(String airCondition) {
            this.airCondition = airCondition;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getColdIndex() {
            return coldIndex;
        }

        public void setColdIndex(String coldIndex) {
            this.coldIndex = coldIndex;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getDistrct() {
            return distrct;
        }

        public void setDistrct(String distrct) {
            this.distrct = distrct;
        }

        public String getDressingIndex() {
            return dressingIndex;
        }

        public void setDressingIndex(String dressingIndex) {
            this.dressingIndex = dressingIndex;
        }

        public String getExerciseIndex() {
            return exerciseIndex;
        }

        public void setExerciseIndex(String exerciseIndex) {
            this.exerciseIndex = exerciseIndex;
        }

        public String getHumidity() {
            return humidity;
        }

        public void setHumidity(String humidity) {
            this.humidity = humidity;
        }

        public String getPollutionIndex() {
            return pollutionIndex;
        }

        public void setPollutionIndex(String pollutionIndex) {
            this.pollutionIndex = pollutionIndex;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getSunrise() {
            return sunrise;
        }

        public void setSunrise(String sunrise) {
            this.sunrise = sunrise;
        }

        public String getSunset() {
            return sunset;
        }

        public void setSunset(String sunset) {
            this.sunset = sunset;
        }

        public String getTemperature() {
            return temperature;
        }

        public void setTemperature(String temperature) {
            this.temperature = temperature;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }

        public String getWashIndex() {
            return washIndex;
        }

        public void setWashIndex(String washIndex) {
            this.washIndex = washIndex;
        }

        public String getWeather() {
            return weather;
        }

        public void setWeather(String weather) {
            this.weather = weather;
        }

        public String getWeek() {
            return week;
        }

        public void setWeek(String week) {
            this.week = week;
        }

        public String getWind() {
            return wind;
        }

        public void setWind(String wind) {
            this.wind = wind;
        }

        public List<FutureBean> getFuture() {
            return future;
        }

        public void setFuture(List<FutureBean> future) {
            this.future = future;
        }

        public static class FutureBean {
            /**
             * date : 2017-03-06
             * dayTime : 多云
             * night : 晴
             * temperature : 10°C / -3°C
             * week : 今天
             * wind : 北风 4～5级
             */

            private String date;
            private String dayTime;
            private String night;
            private String temperature;
            private String week;
            private String wind;

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getDayTime() {
                return dayTime;
            }

            public void setDayTime(String dayTime) {
                this.dayTime = dayTime;
            }

            public String getNight() {
                return night;
            }

            public void setNight(String night) {
                this.night = night;
            }

            public String getTemperature() {
                return temperature;
            }

            public void setTemperature(String temperature) {
                this.temperature = temperature;
            }

            public String getWeek() {
                return week;
            }

            public void setWeek(String week) {
                this.week = week;
            }

            public String getWind() {
                return wind;
            }

            public void setWind(String wind) {
                this.wind = wind;
            }
        }
    }
}
