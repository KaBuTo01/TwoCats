package com.example.twocats.ui.home.explore;

import com.example.twocats.bean.Banners;
import com.example.twocats.bean.HomeData;
import com.example.twocats.bean.JavaBean;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;

/**
 * @ClassName ExplorePresenter
 * @Author name
 * @Date 2023/1/16
 * @Description
 */
public class ExplorePresenter implements ExploreContract.IExplorePresenter{

    private  ExploreContract.IExploreModel expandModel;
    private  ExploreContract.IExploreView IView;

    public ExplorePresenter(ExploreContract.IExploreView IView) {
        this.IView = IView;
        expandModel = new ExploreModel();
    }

    @Override
    public void getHome() {
      expandModel.getHome().subscribeOn(Schedulers.io())
              .observeOn(AndroidSchedulers.mainThread())
              .subscribe(new Consumer<JavaBean<List<HomeData>>>() {
                  @Override
                  public void accept(JavaBean<List<HomeData>> listJavaBean) throws Throwable {
                        IView.onSuccess(listJavaBean.getData());
                  }
              }, new Consumer<Throwable>() {
                  @Override
                  public void accept(Throwable throwable) throws Throwable {
                      IView.onFailure(throwable);
                  }
              });
    }

    @Override
    public void getBanners() {
        expandModel.getBanners().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<JavaBean<List<Banners>>>() {
                    @Override
                    public void accept(JavaBean<List<Banners>> listJavaBean) throws Throwable {
                            IView.onBannersSuccess(listJavaBean.getData());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Throwable {
                        IView.onBannersFailure(throwable);
                    }
                });
    }
}
