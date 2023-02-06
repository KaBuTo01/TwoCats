package com.example.twocats.ui.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * @ClassName BaseFragment
 * @Author name
 * @Date 2023/1/7
 * @Description
 */
public abstract class BaseFragment extends Fragment {

    protected View contentView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        contentView = inflater.inflate(getLayoutId(),container,false);
        initViews();
        return contentView;
    }

    protected abstract void initViews();
    protected abstract int getLayoutId();
    protected <T extends View> T find(@IdRes int id){
        return contentView.findViewById(id);
    }
}
