package com.minhtetoo.goodfood;

import android.app.Application;
import android.content.Context;

import com.minhtetoo.goodfood.dagger.AppComponent;
import com.minhtetoo.goodfood.dagger.AppModule;
import com.minhtetoo.goodfood.dagger.DaggerAppComponent;
import com.minhtetoo.goodfood.data.model.GoodFoodModel;

import javax.inject.Inject;

/**
 * Created by min on 1/19/2018.
 */

public class GoodFoodApp extends Application {

    @Inject
    GoodFoodModel goodFoodModel;

    private AppComponent appComponent;

    @Inject
    Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = initDagger();
        appComponent.inject(this);

        goodFoodModel.startLoadingFeatureds(getApplicationContext());
        goodFoodModel.startLoadingPromotions(getApplicationContext());
        goodFoodModel.startLoadingGuides(getApplicationContext());

    }

    private AppComponent initDagger() {
        return DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
