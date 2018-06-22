package com.demo.thorn.tapps.ui.fragment;

import android.os.Bundle;
import android.view.View;

import com.demo.thorn.tapps.R;
import com.demo.thorn.tapps.base.BaseFragment;


public class ReadFragment extends BaseFragment {

    public static ReadFragment newInstance(){
        ReadFragment readFragment = new ReadFragment();
        return readFragment;
    }


    @Override
    protected int getLyoutId() {
        return R.layout.fragment_read;
    }

    @Override
    protected void initView(View view) {

    }

    @Override
    protected void initData(Bundle savedInstanceState) {

    }
}
