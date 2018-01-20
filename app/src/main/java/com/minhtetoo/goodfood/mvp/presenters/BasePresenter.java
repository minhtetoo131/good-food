package com.minhtetoo.goodfood.mvp.presenters;

import android.database.Cursor;

/**
 * Created by min on 1/20/2018.
 */

public abstract class BasePresenter<T> {

    protected T mView;

    public void onCreate(T view) {
        mView = view;
    }

    public abstract void onStart();

    public void onResume() {

    }

    public void onPause() {

    }

    public abstract void onStop();

    public void onDestroy() {

    }


}