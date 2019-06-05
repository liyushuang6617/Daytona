package com.example.daytona.base;

import java.util.ArrayList;

public class BasePresenter<V extends BaseView, M extends BaseModel> {

    private ArrayList<BaseModel> list = new ArrayList<>();

    protected M myModel;
    protected V myView;

    public void initModel(M m) {
        this.myModel = m;
        list.add(m);
    }

    public void attachView(V v) {
        this.myView = v;
    }

    public void destory() {
        if (myView != null) {
            myView = null;
        }
        if (myModel != null) {
            myModel = null;
        }

        if (list.size() > 0 && list != null) {
            for (BaseModel baseModel :
                    list) {
                baseModel.clear();
            }
        }
    }
}
