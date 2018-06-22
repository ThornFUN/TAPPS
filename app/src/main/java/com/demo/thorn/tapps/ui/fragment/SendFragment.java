package com.demo.thorn.tapps.ui.fragment;

import android.os.Bundle;
import android.view.View;

import com.demo.thorn.tapps.R;
import com.demo.thorn.tapps.base.BaseFragment;


public class SendFragment extends BaseFragment {

    public static SendFragment newInstance(){
        SendFragment sendFragment = new SendFragment();
        return sendFragment;
    }


    @Override
    protected int getLyoutId() {
        return R.layout.fragment_send;
    }

    @Override
    protected void initView(View view) {

    }

    @Override
    protected void initData(Bundle savedInstanceState) {

    }
}
