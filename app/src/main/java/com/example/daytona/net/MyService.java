package com.example.daytona.net;

import com.example.daytona.bean.HotBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface MyService {

    public String url = "http://news-at.zhihu.com/api/4/";

    @GET("news/hot")
    Observable<HotBean> hot();
}
