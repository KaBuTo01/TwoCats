package com.example.twocats.ui.home;

import androidx.annotation.NonNull;
import androidx.viewpager2.widget.ViewPager2;

import com.example.twocats.R;
import com.example.twocats.ui.base.BaseFragment;
import com.example.twocats.ui.home.adapter.HomePagerAdapter;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName home
 * @Author name
 * @Date 2023/1/7
 * @Description
 */
public class HomeFragment extends BaseFragment {
    private TabLayout mTabLayout;
    private ViewPager2 mViewPager2;
    @Override
    protected void initViews() {
        mTabLayout = find(R.id.home_indicator);
        mViewPager2 = find(R.id.home_pager);
        mViewPager2.setAdapter(new HomePagerAdapter(getActivity()));
        TabLayoutMediator tab = new TabLayoutMediator(mTabLayout, mViewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position){
                    case 0:
                        tab.setText(getResources().getString(R.string.home_subscription));
                        break;
                    case 1:
                        tab.setText(getResources().getString(R.string.home_explore));
                        break;
                    case 2:
                        tab.setText(getResources().getString(R.string.home_strayCat));
                        break;
                }
            }
        });
        tab.attach();
        mTabLayout.getTabAt(1).select();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }
}
