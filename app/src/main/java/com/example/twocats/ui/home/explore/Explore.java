package com.example.twocats.ui.home.explore;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.twocats.R;
import com.example.twocats.bean.Banners;
import com.example.twocats.bean.HomeData;
import com.example.twocats.ui.base.BaseFragment;
import com.example.twocats.ui.detail.detail;
import com.example.twocats.ui.home.adapter.ExploreResyclerViewAdapter;
import com.youth.banner.Banner;
import com.youth.banner.adapter.BannerImageAdapter;
import com.youth.banner.holder.BannerImageHolder;
import com.youth.banner.indicator.CircleIndicator;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Explore
 * @Author name
 * @Date 2023/1/8
 * @Description
 */
public class Explore extends BaseFragment implements ExploreContract.IExploreView,SwipeRefreshLayout.OnRefreshListener, NestedScrollView.OnScrollChangeListener {

    private ExploreResyclerViewAdapter exploreAdapter;
    private ExplorePresenter explorePresenter;
    private RecyclerView recyclerView;
    private Banner banner;
    private int loading;
    private SwipeRefreshLayout swip;
    private NestedScrollView nested;

    @Override
    protected void initViews() {
        swip = find(R.id.explore_swipe);
        swip.setOnRefreshListener(this);
        recyclerView = find(R.id.recycler_view);
        nested = find(R.id.nested_scroll);
        nested.setOnScrollChangeListener(this);
        banner = find(R.id.banner);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        List<HomeData> data = new ArrayList<>();
        exploreAdapter = new ExploreResyclerViewAdapter(getContext(), data);
        recyclerView.setAdapter(exploreAdapter);
        explorePresenter = new ExplorePresenter(this);
        explorePresenter.getHome();
        explorePresenter.getBanners();
        exploreAdapter.setOnclick(new ExploreResyclerViewAdapter.ClickInterface() {
            @Override
            public void onImageClick(View view, int id,String name,String head,String title) {
                Toast.makeText(view.getContext(), "Click Button - position: " + id , Toast.LENGTH_SHORT).show();
                 Intent intent = new Intent(getContext(), detail.class);
                Bundle bundle =new Bundle();
                bundle.putString("id",String.valueOf(id));
                bundle.putString("name",name);
                bundle.putString("head",head);
                bundle.putString("title",title);
                intent.putExtras(bundle);
                 startActivity(intent);
            }

            @Override
            public void onHeadClick(View view, int id) {
                Toast.makeText(view.getContext(), "Click Button - u: " + id , Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_explore;
    }

    @Override
    public void onRefresh() {
        swip.setRefreshing(true);
        loading = 0;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (loading==0){
                    loading=1;
                    explorePresenter.getHome();
                    swip.setRefreshing(false);
                }
            }
        },2000);


    }

    @Override
    public void onSuccess(List<HomeData> data) {
        exploreAdapter.addData(data, 1);
    }

    @Override
    public void onFailure(Throwable throwable) {

    }

    @Override
    public void onBannersSuccess(List<Banners> data) {
        banner.setAdapter(new BannerImageAdapter<Banners>(data) {
                    @Override
                    public void onBindView(BannerImageHolder holder, Banners mdata, int position, int size) {
                        //图片加载自己实现
                        Glide.with(getContext())
                                .load(mdata.getImageUrl())
                                .apply(RequestOptions.bitmapTransform(new RoundedCorners(30)))
                                .into(holder.imageView);
                    }
                })
                .setBannerGalleryEffect(10,10)
                .setBannerRound2(15)
                .addBannerLifecycleObserver(this)//添加生命周期观察者
                .setIndicator(new CircleIndicator(getContext()));

    }

    @Override
    public void onBannersFailure(Throwable throwable) {

    }

    @Override
    public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
        if (scrollY == (v.getChildAt(0).getMeasuredHeight() - v.getMeasuredHeight())) {
             loading = 0;
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (loading == 0){
                        loading = 1;
                        explorePresenter.getHome();
                    }
                }
            },2000);

        }
    }
}
