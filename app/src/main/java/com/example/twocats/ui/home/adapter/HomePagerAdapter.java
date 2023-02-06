package com.example.twocats.ui.home.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.example.twocats.ui.home.explore.Explore;
import com.example.twocats.ui.home.stray_cat.StrayCat;
import com.example.twocats.ui.home.subscription.Subscription;

/**
 * @ClassName HomePagerAdapter
 * @Author name
 * @Date 2023/1/8
 * @Description
 */
public class HomePagerAdapter extends FragmentStateAdapter {
    public HomePagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }
    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new Subscription();
            case 1:
                return new Explore();
            default:
                return new StrayCat();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
