package com.demo.thorn.tapps.net;

import com.demo.thorn.tapps.databean.PhotoBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Carson_Ho on 17/3/20.
 */

public interface GetGalleryRequest_Interface {


    @GET("/api/data/福利/10/{page}")
    Call<PhotoBean> getDatabean(@Path("page") int page);
    // 注解里传入 网络请求 的部分URL地址
    // getCall()是接受网络请求数据的方法
}
