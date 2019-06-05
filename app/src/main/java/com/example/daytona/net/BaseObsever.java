package com.example.daytona.net;

import android.util.Log;

import io.reactivex.Observer;

public abstract class BaseObsever<T> implements Observer<T> {
    @Override
    public void onError(Throwable e) {
        Log.e("BaseObsever", "onError: " + e.getMessage());
    }

    @Override
    public void onComplete() {
        Log.e("BaseObsever", "onError: " + "onComplete");
    }
}
