package com.example.twocats.ui.detail;

import com.example.twocats.bean.Content;
import com.example.twocats.bean.DetailImage;
import com.example.twocats.bean.JavaBean;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;

/**
 * @ClassName DetailPresenter
 * @Author name
 * @Date 2023/1/29
 * @Description
 */
public class DetailPresenter implements DetailContract.IDetailPresenter {
    private DetailContract.IDetailModel detailModel;
    private DetailContract.IDetailView detailView;

    public DetailPresenter( DetailContract.IDetailView detailView) {
        this.detailView = detailView;
        detailModel=new DetailModel();
    }

    @Override
    public void getImage(int id) {
        detailModel.getImage(id).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<JavaBean<List<DetailImage>>>() {
            @Override
            public void accept(JavaBean<List<DetailImage>> listJavaBean) throws Throwable {
               detailView.ImageSuccess(listJavaBean.getData());
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Throwable {
                detailView.ImageFailure(throwable);
            }
        });
    }

    @Override
    public void getContent(int id) {
        detailModel.getContent(id).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<JavaBean<List<Content>>>() {
                    @Override
                    public void accept(JavaBean<List<Content>> listJavaBean) throws Throwable {
                        detailView.ContentSuccess(listJavaBean.getData());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Throwable {
                        detailView.ContentFailure(throwable);
                    }
                });
    }
}
