package com.example.daytona.presenter;

import com.example.daytona.base.BaseCallBack;
import com.example.daytona.base.BasePresenter;
import com.example.daytona.bean.HotBean;
import com.example.daytona.model.HotM;
import com.example.daytona.view.HotV;

public class HotP extends BasePresenter<HotV,HotM> {
    public void getData() {
        if(myModel!=null){
            myModel.getData(new BaseCallBack<HotBean>() {
                @Override
                public void onSuccess(HotBean hotBean) {
                    if(myView!=null){
                        myView.onSuccess(hotBean);
                    }
                }

                @Override
                public void onFail(String msg) {
                    if(myView!=null){
                        myView.onFail(msg);
                    }
                }
            });
        }
    }
}
