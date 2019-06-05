package com.example.daytona;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;

import com.example.daytona.base.BaseActivity;
import com.example.daytona.fragment.AboutFragment;
import com.example.daytona.fragment.CollectFragment;
import com.example.daytona.fragment.GankFragment;
import com.example.daytona.fragment.GoldFragment;
import com.example.daytona.fragment.SettingFragment;
import com.example.daytona.fragment.V2exFragment;
import com.example.daytona.fragment.WechatFragment;
import com.example.daytona.fragment.ZhihuNewDayFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    private static final int TYPE_ZHIHU = 0;
    private static final int TYPE_WECHAT = 1;
    private static final int TYPE_GANK = 2;
    private static final int TYPE_GOLD= 3;
    private static final int TYPE_V2EX = 4;
    private static final int TYPE_COLLECT = 5;
    private static final int TYPE_SETTING = 6;
    private static final int TYPE_ABOUT = 7;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.nv)
    NavigationView nv;
    @BindView(R.id.dl)
    DrawerLayout dl;
    private ArrayList<Integer> title;
    private ArrayList<Fragment> list;
    private FragmentManager manager;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {

        toolbar.setTitle(R.string.zhihu);

        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, dl, toolbar, R.string.about, R.string.about);
        toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.white));
        dl.addDrawerListener(toggle);
        toggle.syncState();

        addFragment();
        addTitle();

        manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.fl, list.get(0));
        transaction.commit();


    }

    @Override
    protected void initListener() {
        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                menuItem.setChecked(true);
                switch (menuItem.getItemId()) {
                    case R.id.zhihu:
                        switchFragment(TYPE_ZHIHU);
                        break;
                    case R.id.wechat:
                        switchFragment(TYPE_WECHAT);
                        break;
                    case R.id.gank:
                        switchFragment(TYPE_GANK);
                        break;
                    case R.id.gold:
                        switchFragment(TYPE_GOLD);
                        break;
                    case R.id.vtex:
                        switchFragment(TYPE_V2EX);
                        break;
                    case R.id.collect:
                        switchFragment(TYPE_COLLECT);
                        break;
                    case R.id.setting:
                        switchFragment(TYPE_SETTING);
                        break;
                    case R.id.about:
                        switchFragment(TYPE_ABOUT);
                        break;
                }
                dl.closeDrawer(Gravity.LEFT);
                return false;
            }
        });
    }

    private int last = 0;

    private void switchFragment(int type) {
        Fragment fragment = list.get(type);
        Fragment lastFragment = list.get(last);
        FragmentTransaction transaction = manager.beginTransaction();
        if (!fragment.isAdded()) {
            transaction.add(R.id.fl, fragment);
        }
        transaction.show(fragment);
        transaction.hide(lastFragment);
        transaction.commit();
        last = type;

        toolbar.setTitle(title.get(type));
    }

    private void addTitle() {
        title = new ArrayList<>();
        title.add(R.string.zhihu);
        title.add(R.string.wechat);
        title.add(R.string.gank);
        title.add(R.string.gold);
        title.add(R.string.vtex);
        title.add(R.string.collect);
        title.add(R.string.setting);
        title.add(R.string.about);
    }

    private void addFragment() {
        list = new ArrayList<>();
        list.add(new ZhihuNewDayFragment());
        list.add(new WechatFragment());
        list.add(new GankFragment());
        list.add(new GoldFragment());
        list.add(new V2exFragment());
        list.add(new CollectFragment());
        list.add(new SettingFragment());
        list.add(new AboutFragment());
    }
}
