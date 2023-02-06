package com.example.twocats.ui.home.explore;

import com.example.twocats.bean.Banners;
import com.example.twocats.bean.HomeData;
import com.example.twocats.bean.JavaBean;
import com.example.twocats.network.RetrofitClient;
import com.example.twocats.network.service.HomeService;

import java.util.List;

import io.reactivex.rxjava3.core.Flowable;

/**
 * @ClassName ExploreModel
 * @Author name
 * @Date 2023/1/16
 * @Description
 */
public class ExploreModel implements ExploreContract.IExploreModel {


    @Override
    public Flowable<JavaBean<List<HomeData>>> getHome() {
        return RetrofitClient.getInstance().getService(HomeService.class)
                .getHome();
    }

    @Override
    public Flowable<JavaBean<List<Banners>>> getBanners() {
        return RetrofitClient.getInstance().getService(HomeService.class)
                .getBanners();
    }


}
