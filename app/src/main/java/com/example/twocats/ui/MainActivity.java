package com.example.twocats.ui;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.twocats.R;
import com.example.twocats.ui.add.AddFragment;
import com.example.twocats.ui.base.BaseActivity;
import com.example.twocats.ui.store.StoreFragment;
import com.example.twocats.ui.home.HomeFragment;
import com.example.twocats.ui.message.MessageFragment;
import com.example.twocats.ui.user.UserFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends BaseActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private Fragment[] fragments;
    private int lastFragmentIndex=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.Theme_TwoCats);
        super.onCreate(savedInstanceState);
        if (getSupportActionBar() != null){
            getSupportActionBar().hide();
        }

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initViews() {
        BottomNavigationView bottomNavigationView =find(R.id.main_navigation_bottom);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        fragments=new Fragment[] {new HomeFragment()
                ,new StoreFragment()
                ,new AddFragment()
                ,new MessageFragment()
                ,new UserFragment()};
        getSupportFragmentManager().beginTransaction()
                .add(R.id.main_fram,fragments[0])
                .commit();
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.home:
                switchFragment(0);
                break;
            case R.id.friend:
                switchFragment(1);
                break;
            case R.id.add:
                switchFragment(2);
                break;
            case R.id.message:
                switchFragment(3);
                break;
            case R.id.user:
                switchFragment(4);
                break;
        }

        return true;
    }
    private void switchFragment(int to){
        if (lastFragmentIndex==to){
            return;
        }
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        if (!fragments[to].isAdded()){
            fragmentTransaction.add(R.id.main_fram,fragments[to]);
        }else {
            fragmentTransaction.show(fragments[to]);
        }
        fragmentTransaction.hide(fragments[lastFragmentIndex]).commitAllowingStateLoss();
        lastFragmentIndex=to;
    }

}