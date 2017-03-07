package com.stevefat.coolweather.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.stevefat.coolweather.contract.MainContract;

/**
 * Created by stevefat on 2017/3/6.
 */

public abstract class BaseFragment extends Fragment {
    public View mView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = getlayoutView(inflater);
        initView();
        return mView;
    }

    public abstract View getlayoutView(LayoutInflater inflater);

    public abstract void initView();

}
