package com.example.twocats.ui.detail;

import com.example.twocats.bean.Content;
import com.example.twocats.bean.DetailImage;
import com.example.twocats.bean.JavaBean;
import com.example.twocats.network.RetrofitClient;
import com.example.twocats.network.service.HomeService;

import java.util.List;

import io.reactivex.rxjava3.core.Flowable;

/**
 * @ClassName DetailModel
 * @Author name
 * @Date 2023/1/29
 * @Description
 */
public class DetailModel implements DetailContract.IDetailModel {
    @Override
    public Flowable<JavaBean<List<DetailImage>>> getImage(int id) {
        return RetrofitClient.getInstance().getService(HomeService.class).getImage(id);
    }

    @Override
    public Flowable<JavaBean<List<Content>>> getContent(int id) {
        return RetrofitClient.getInstance().getService(HomeService.class).getContent(id);
    }
}
