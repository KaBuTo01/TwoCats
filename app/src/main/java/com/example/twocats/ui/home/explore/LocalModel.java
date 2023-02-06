package com.example.twocats.ui.home.explore;

import com.example.twocats.bean.Banners;
import com.example.twocats.bean.HomeData;
import com.example.twocats.bean.JavaBean;

import java.util.List;

import io.reactivex.rxjava3.core.Flowable;

/**
 * @ClassName LocalModel
 * @Author name
 * @Date 2023/1/16
 * @Description
 */
public class LocalModel implements ExploreContract.IExploreModel {


    @Override
    public Flowable<JavaBean<List<HomeData>>> getHome() {
        return null;
    }

    @Override
    public Flowable<JavaBean<List<Banners>>> getBanners() {
        return null;
    }


}
