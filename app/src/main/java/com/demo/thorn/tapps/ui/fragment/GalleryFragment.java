package com.demo.thorn.tapps.ui.fragment;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import retrofit2.converter.gson.GsonConverterFactory;
import com.demo.thorn.tapps.net.GetGalleryRequest_Interface;
import com.demo.thorn.tapps.R;
import com.demo.thorn.tapps.base.BaseFragment;
import com.demo.thorn.tapps.databean.PhotoBean;
import com.demo.thorn.tapps.ui.adapter.GalleryAdapter;
import com.demo.thorn.tapps.util.ConstantUtil;
import com.demo.thorn.tapps.util.LogUtil;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class GalleryFragment extends BaseFragment  {


    int page;
    GalleryAdapter galleryAdapter;
    RecyclerView rl_content;
    SwipeRefreshLayout srl_refresh;

    ArrayList<PhotoBean.ResultsBean> resultsBeans;

    GetGalleryRequest_Interface request;
    Call<PhotoBean> call;



    public static GalleryFragment newInstance(){
        GalleryFragment galleryFragment = new GalleryFragment();
        return galleryFragment;
    }


    @Override
    protected int getLyoutId() {
        return R.layout.fragment_gallery;
    }

    @Override
    protected void initView(View view) {
        rl_content = view.findViewById(R.id.rl_content);
        srl_refresh = view.findViewById(R.id.srl_refresh);

        srl_refresh.setColorSchemeColors(Color.BLUE);

    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void initData(Bundle savedInstanceState) {
        page = 1;
        resultsBeans = new ArrayList<PhotoBean.ResultsBean>();

        //步骤4:创建Retrofit对象
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(ConstantUtil.BASE_GALLERY_URL)
                .build();

        // 步骤5:创建 网络请求接口 的实例
         request = retrofit.create(GetGalleryRequest_Interface.class);

        //对 发送请求 进行封装
        call = request.getDatabean(page);

        //步骤6:发送网络请求(异步)
        call.enqueue(new Callback<PhotoBean>() {
            //请求成功时候的回调
            @Override
            public void onResponse(Call<PhotoBean> call, Response<PhotoBean> response) {
                //请求处理,输出结
                resultsBeans = (ArrayList<PhotoBean.ResultsBean>) response.body().getResults();
                galleryAdapter = new GalleryAdapter(resultsBeans);
                GridLayoutManager layoutManager = new GridLayoutManager(getContext(),2);
                rl_content.setLayoutManager(layoutManager);
                rl_content.setAdapter(galleryAdapter);

            }

            //请求失败时候的回调
            @Override
            public void onFailure(Call<PhotoBean> call, Throwable throwable) {
                LogUtil.v("初始化失败");
            }
        });

        srl_refresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                LogUtil.d("下拉刷新"+page);

                call = request.getDatabean(page++);
                call.enqueue(new Callback<PhotoBean>() {
                    @Override
                    public void onResponse(Call<PhotoBean> call, Response<PhotoBean> response) {

                        if(response !=null){
                            resultsBeans.clear();
                            resultsBeans.addAll((ArrayList<PhotoBean.ResultsBean>) response.body().getResults());
                            srl_refresh.setRefreshing(false);
                            galleryAdapter.notifyDataSetChanged();//全部刷新，加载下一页
                        }
                    }

                    @Override
                    public void onFailure(Call<PhotoBean> call, Throwable t) {
                        LogUtil.v("刷新失败");
                    }
                });


            }
        });



    }
}
