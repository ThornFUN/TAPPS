package com.demo.thorn.tapps.ui.fragment;

import android.os.Bundle;
import android.view.View;

import com.demo.thorn.tapps.R;
import com.demo.thorn.tapps.base.BaseFragment;


public class VideoFragment extends BaseFragment {

    public static VideoFragment newInstance(){
        VideoFragment videoFragment = new VideoFragment();
        return videoFragment;
    }


    @Override
    protected int getLyoutId() {
        return R.layout.fragment_video;
    }

    @Override
    protected void initView(View view) {

    }

    @Override
    protected void initData(Bundle savedInstanceState) {

    }
}
