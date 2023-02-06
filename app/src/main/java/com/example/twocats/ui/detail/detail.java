package com.example.twocats.ui.detail;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.twocats.R;
import com.example.twocats.bean.Banners;
import com.example.twocats.bean.Content;
import com.example.twocats.bean.DetailImage;
import com.example.twocats.ui.base.BaseActivity;
import com.example.twocats.ui.detail.adapter.ContractRecyclerViewAdapter;
import com.youth.banner.Banner;
import com.youth.banner.adapter.BannerImageAdapter;
import com.youth.banner.holder.BannerImageHolder;
import com.youth.banner.indicator.CircleIndicator;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName detail
 * @Author name
 * @Date 2023/1/28
 * @Description
 */
public class detail extends BaseActivity implements View.OnClickListener, DetailContract.IDetailView {
    final static String TAG = detail.class.getSimpleName();
    private ImageButton btn;
    private String id,head,name,title;
    private DetailPresenter detailPresenter;
    private Banner banner;
    private TextView user_name,user_name1;
    private ImageView user_head;
    private TextView title1;
    private RecyclerView recyclerView;
    private ContractRecyclerViewAdapter contractRecyclerViewAdapter;

    @Override
    protected void initViews() {
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.hide();
        }
        btn = find(R.id.bt1);
        user_name = find(R.id.user_name);
        user_name1 = find(R.id.user_name1);
        user_head = find(R.id.user_head);
        title1 = find(R.id.title);
        banner = find(R.id.banner);
        recyclerView = find(R.id.recycler_view);
        //创建布局管理器
        LinearLayoutManager linearLayoutManager =new LinearLayoutManager(this);
        //设置布局管理器
        recyclerView.setLayoutManager(linearLayoutManager);
        List<Content> data=new ArrayList<>();
        contractRecyclerViewAdapter = new ContractRecyclerViewAdapter(data,this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setNestedScrollingEnabled(false);
        //设置适配器
        recyclerView.setAdapter(contractRecyclerViewAdapter);
        btn.setOnClickListener(this);

        Intent intent =getIntent();
        Bundle bundle = intent.getExtras();
        id = bundle.getString("id");
        head = bundle.getString("head");
        name = bundle.getString("name");
        title = bundle.getString("title");
        user_name.setText(name);
        user_name1.setText(name);
        title1.setText(title);
        Glide.with(detail.this)
                .load(head)
                .into(user_head);
        detailPresenter = new DetailPresenter(this);
        detailPresenter.getImage(Integer.parseInt(id));
        detailPresenter.getContent(Integer.parseInt(id));
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_detail;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt1:
                finish();
                break;
        }
    }

    @Override
    public void ImageSuccess(List<DetailImage> data) {
        Log.e(TAG, "ImageSuccess: "+data.get(0).getImage() );
        banner.setAdapter(new BannerImageAdapter<DetailImage>(data) {
                    @Override
                    public void onBindView(BannerImageHolder holder, DetailImage mdata, int position, int size) {
                        //图片加载自己实现
                        Glide.with(detail.this)
                                .load(mdata.getImage())
                                .into(holder.imageView);
                    }
                })
                .isAutoLoop(false)
                .addBannerLifecycleObserver(this)//添加生命周期观察者
                .setIndicator(new CircleIndicator(detail.this));

    }

    @Override
    public void ImageFailure(Throwable throwable) {

    }

    @Override
    public void ContentSuccess(List<Content> data) {
        contractRecyclerViewAdapter.addData(data);
    }

    @Override
    public void ContentFailure(Throwable throwable) {

    }
}
