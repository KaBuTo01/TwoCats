package com.example.twocats.ui.home.explore;

import com.example.twocats.bean.Banners;
import com.example.twocats.bean.HomeData;
import com.example.twocats.bean.JavaBean;

import java.util.List;

import io.reactivex.rxjava3.core.Flowable;

/**
 * @ClassName ExploreContract
 * @Author name
 * @Date 2023/1/16
 * @Description
 */
public interface ExploreContract {
    interface IExplorePresenter{
        void getHome();
        void getBanners();
    }
    interface IExploreModel{
        Flowable<JavaBean<List<HomeData>>> getHome();
        Flowable<JavaBean<List<Banners>>> getBanners();
    }
    interface IExploreView{
        void onSuccess(List<HomeData> data);
        void onFailure(Throwable throwable);
        void onBannersSuccess(List<Banners> data);
        void onBannersFailure(Throwable throwable);


    }
}
