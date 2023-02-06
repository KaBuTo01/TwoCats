package com.example.twocats.network.service;

import com.example.twocats.bean.Banners;
import com.example.twocats.bean.Content;
import com.example.twocats.bean.DetailImage;
import com.example.twocats.bean.HomeData;
import com.example.twocats.bean.JavaBean;

import java.util.List;

import io.reactivex.rxjava3.core.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @ClassName HomeService
 * @Author name
 * @Date 2023/1/13
 * @Description
 */
public interface HomeService {
    //首页
    @GET("test/getHome")
    Flowable<JavaBean<List<HomeData>>> getHome();
    //首页轮播图
    @GET("test/banner")
    Flowable<JavaBean<List<Banners>>> getBanners();
    @GET("test/getImage")
    Flowable<JavaBean<List<DetailImage>>> getImage(@Query("id")int id);
    @GET("test/getContent")
    Flowable<JavaBean<List<Content>>> getContent(@Query("id")int id);
}
