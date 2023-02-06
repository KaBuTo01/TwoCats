package com.example.twocats.ui.detail;

import com.example.twocats.bean.Content;
import com.example.twocats.bean.DetailImage;
import com.example.twocats.bean.HomeData;
import com.example.twocats.bean.JavaBean;

import java.util.List;

import io.reactivex.rxjava3.core.Flowable;

/**
 * @ClassName DetailContract
 * @Author name
 * @Date 2023/1/29
 * @Description
 */
public interface DetailContract {
    interface IDetailPresenter{
        void getImage(int id);
        void getContent(int id);
    }
    interface IDetailModel{
        Flowable<JavaBean<List<DetailImage>>> getImage(int id);
        Flowable<JavaBean<List<Content>>> getContent(int id);
    }
    interface IDetailView{
        void ImageSuccess(List<DetailImage> data);
        void ImageFailure(Throwable throwable);

        void ContentSuccess(List<Content> data);
        void ContentFailure(Throwable throwable);

    }
}
