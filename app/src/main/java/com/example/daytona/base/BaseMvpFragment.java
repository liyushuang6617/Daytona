package com.example.daytona.base;

public abstract class BaseMvpFragment
        <P extends BasePresenter,V extends BaseView,M extends BaseModel> extends BaseFragment{

    protected P mPresenter;

    @Override
    protected void initMvp() {
        mPresenter = initMvpPresenter();
        if(mPresenter!=null){
            mPresenter.attachView(initMvpView());
            mPresenter.initModel(initMvpModel());
        }
    }

    protected abstract M initMvpModel();

    protected abstract V initMvpView();

    protected abstract P initMvpPresenter();

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(mPresenter!=null){
            mPresenter.destory();
            mPresenter = null;
        }
    }
}
