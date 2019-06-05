package com.example.daytona.base;

import io.reactivex.disposables.CompositeDisposable;

public class BaseModel {

    protected CompositeDisposable compositeDisposable = new CompositeDisposable();

    public void clear(){
        compositeDisposable.clear();
    }
}
