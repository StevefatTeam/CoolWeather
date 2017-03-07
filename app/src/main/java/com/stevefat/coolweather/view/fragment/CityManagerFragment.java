package com.stevefat.coolweather.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.stevefat.coolweather.contract.CityManagerContract;

/**
 * Created by stevefat on 2017/3/4.
 */

public class CityManagerFragment extends Fragment implements CityManagerContract.View {

    public static CityManagerFragment newInstance() {

        Bundle args = new Bundle();

        CityManagerFragment fragment = new CityManagerFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void setPresenter(CityManagerContract.Presenter presenter) {

    }

    @Override
    public void displaySavedCitys() {

    }
}
