package com.stevefat.coolweather.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.stevefat.coolweather.contract.MainContract;

import butterknife.ButterKnife;

/**
 * Created by stevefat on 2017/3/6.
 */

public abstract class BaseFragment extends Fragment {
    public View rootView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        rootView = getlayoutView(inflater);
        ButterKnife.bind(this, rootView);
        initView();
        return rootView;
    }

    public abstract View getlayoutView(LayoutInflater inflater);

    public abstract void initView();

}
