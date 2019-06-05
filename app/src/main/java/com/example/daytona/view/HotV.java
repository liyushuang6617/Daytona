package com.example.daytona.view;

import com.example.daytona.base.BaseView;
import com.example.daytona.bean.HotBean;

public interface HotV extends BaseView {
    void onSuccess(HotBean hotBean);

    void onFail(String msg);
}
