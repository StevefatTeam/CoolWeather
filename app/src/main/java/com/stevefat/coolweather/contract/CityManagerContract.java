package com.stevefat.coolweather.contract;

import com.stevefat.coolweather.activity.component.BasePresenter;
import com.stevefat.coolweather.activity.component.BaseView;

import java.util.List;

/**
 * Created by stevefat on 2017/3/4.
 */

public interface CityManagerContract {

    interface View extends BaseView<Presenter> {
        void displaySavedCitys();

    }

    interface Presenter extends BasePresenter {
        void loadCity();
    }

}
