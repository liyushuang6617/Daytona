package com.example.daytona.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.daytona.R;
import com.example.daytona.adapter.RlvHotAdapter;
import com.example.daytona.base.BaseMvpFragment;
import com.example.daytona.bean.HotBean;
import com.example.daytona.model.HotM;
import com.example.daytona.presenter.HotP;
import com.example.daytona.view.HotV;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class ZhihuNewDayFragment extends BaseMvpFragment<HotP, HotV, HotM> implements HotV {

    private static final String TAG = ZhihuNewDayFragment.class.getName();
    @BindView(R.id.re)
    RecyclerView re;
    Unbinder unbinder;
    private ArrayList<HotBean.RecentBean> list;
    private RlvHotAdapter adapter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_zhihu_new_day;
    }

    @Override
    protected HotM initMvpModel() {
        return new HotM();
    }

    @Override
    protected HotV initMvpView() {
        return this;
    }

    @Override
    protected HotP initMvpPresenter() {
        return new HotP();
    }

    @Override
    protected void initView() {
        list = new ArrayList<>();
        adapter = new RlvHotAdapter(getActivity(), list);
        re.setAdapter(adapter);
        re.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    @Override
    protected void initData() {
        mPresenter.getData();
    }

    @Override
    public void onSuccess(HotBean hotBean) {
        list.addAll(hotBean.getRecent());
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onFail(String msg) {
        Log.e(TAG, "onFail: " +msg );
    }
}
