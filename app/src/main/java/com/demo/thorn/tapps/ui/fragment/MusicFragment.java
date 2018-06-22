package com.demo.thorn.tapps.ui.fragment;

import android.os.Bundle;
import android.view.View;

import com.demo.thorn.tapps.R;
import com.demo.thorn.tapps.base.BaseFragment;


public class MusicFragment extends BaseFragment {

    public static MusicFragment newInstance(){
        MusicFragment musicFragment = new MusicFragment();
        return musicFragment;
    }


    @Override
    protected int getLyoutId() {
        return R.layout.fragment_music;
    }

    @Override
    protected void initView(View view) {

    }

    @Override
    protected void initData(Bundle savedInstanceState) {

    }
}
