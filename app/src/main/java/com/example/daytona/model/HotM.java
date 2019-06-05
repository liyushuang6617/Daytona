package com.example.daytona.model;

import com.example.daytona.base.BaseCallBack;
import com.example.daytona.base.BaseModel;
import com.example.daytona.bean.HotBean;
import com.example.daytona.net.BaseObsever;
import com.example.daytona.net.HttpUtils;
import com.example.daytona.net.MyService;
import com.example.daytona.net.RxUtils;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

public class HotM extends BaseModel {
    public void getData(final BaseCallBack<HotBean> baseCallBack) {
        MyService apiService = HttpUtils.getHttpUtils().getApiService(MyService.url, MyService.class);
        Observable<HotBean> hot = apiService.hot();
        hot.compose(RxUtils.<HotBean>observableTransformer())
                .subscribe(new BaseObsever<HotBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.dispose();
                    }

                    @Override
                    public void onNext(HotBean hotBean) {
                        if (hotBean != null) {
                            baseCallBack.onSuccess(hotBean);
                        }
                    }
                });
    }
}
