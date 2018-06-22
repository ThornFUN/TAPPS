package com.demo.thorn.tapps.ui.fragment;

import android.os.Bundle;
import android.view.View;

import com.demo.thorn.tapps.R;
import com.demo.thorn.tapps.base.BaseFragment;


public class WeatherFragment extends BaseFragment {

    public static WeatherFragment newInstance(){
        WeatherFragment weatherFragment = new WeatherFragment();
        return weatherFragment;
    }


    @Override
    protected int getLyoutId() {
        return R.layout.fragment_weather;
    }

    @Override
    protected void initView(View view) {

    }

    @Override
    protected void initData(Bundle savedInstanceState) {

    }
}
